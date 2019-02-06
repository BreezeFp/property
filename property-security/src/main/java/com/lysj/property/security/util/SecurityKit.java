package com.lysj.property.security.util;

import com.lysj.property.security.entity.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityKit {

    public static SecurityUser getUser() {
        return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
