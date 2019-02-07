package com.lysj.property.admin.api;

import com.lysj.property.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    protected JwtTokenUtil jwtTokenUtil;

}
