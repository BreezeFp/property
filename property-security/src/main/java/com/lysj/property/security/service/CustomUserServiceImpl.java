package com.lysj.property.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lysj.property.dao.sys.RoleMapper;
import com.lysj.property.dao.sys.UserMapper;
import com.lysj.property.dao.sys.UserRoleMapper;
import com.lysj.property.entity.sys.Role;
import com.lysj.property.entity.sys.User;
import com.lysj.property.entity.sys.UserRole;
import com.lysj.property.security.entity.SecurityUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fupeng
 * @date 2019/1/25
 */
public class CustomUserServiceImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", s));
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<UserRole> userRoles = userRoleMapper.selectList(new QueryWrapper<UserRole>().eq("user_id", user.getId()));
        List<Role> roles = roleMapper.selectBatchIds(userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
        return createUserDetails(user,roles);
    }

    private UserDetails createUserDetails(User user, List<Role> roles) {
        String[]               roleNames          = roles.stream().map(Role::getCode).toArray(String[]::new);
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.createAuthorityList(roleNames);
        SecurityUser           securityUser       = new SecurityUser();
        BeanUtils.copyProperties(user, securityUser);
        securityUser.setAuthorities(grantedAuthorities);
        return securityUser;
    }
}
