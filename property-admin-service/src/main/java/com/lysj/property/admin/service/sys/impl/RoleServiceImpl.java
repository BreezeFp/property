package com.lysj.property.admin.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lysj.property.admin.service.sys.IRoleService;
import com.lysj.property.dao.sys.RoleMapper;
import com.lysj.property.dao.sys.UserRoleMapper;
import com.lysj.property.entity.sys.Role;
import com.lysj.property.entity.sys.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    UserRoleMapper userRoleMapper;

    @Autowired
    public RoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public List<Role> getRoleByUserId(Long userId) {
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.select("role_id").eq("user_id", userId);
        List<UserRole> userRoles = userRoleMapper.selectList(userRoleQueryWrapper);
        List<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        return new ArrayList<>(listByIds(roleIds));
    }
}
