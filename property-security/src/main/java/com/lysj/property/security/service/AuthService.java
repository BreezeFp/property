package com.lysj.property.security.service;

import com.lysj.property.security.entity.SecurityUser;

/**
 * @author fupeng
 * @date 2019/1/25
 */
public interface AuthService {

    SecurityUser register(SecurityUser userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);

}
