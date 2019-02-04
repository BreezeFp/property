package com.lysj.property.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lysj.property.dao.sys.*;
import com.lysj.property.entity.sys.User;
import com.lysj.property.security.config.JwtProperties;
import com.lysj.property.security.entity.SecurityUser;
import com.lysj.property.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author fupeng
 * @date 2019/1/25
 */
@Service
public class AuthServiceImpl implements com.lysj.property.security.service.AuthService {
    
    private AuthenticationManager authenticationManager;
    private UserDetailsService    userDetailsService;
    private JwtTokenUtil          jwtTokenUtil;
    private UserMapper            userMapper;
    private RoleMapper            roleMapper;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            @Qualifier("customUserService") UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            UserMapper userMapper,
            RoleMapper roleMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public SecurityUser register(SecurityUser userToAdd) {
        final String username = userToAdd.getUsername();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if(user!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder     = new BCryptPasswordEncoder();
        final String          rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        userMapper.insert(userToAdd);
        //TODO:注册时添加默认角色
        roleMapper.addDefaultRole(userToAdd.getId());
        return userToAdd;
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(jwtProperties.getTokenHead().length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        SecurityUser user = (SecurityUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}
