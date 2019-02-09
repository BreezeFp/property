package com.lysj.property.admin.api.sys;

import com.lysj.property.admin.api.BaseController;
import com.lysj.property.common.DataResponse;
import com.lysj.property.security.config.JwtProperties;
import com.lysj.property.security.entity.SecurityUser;
import com.lysj.property.security.service.AuthService;
import com.lysj.property.security.entity.JwtAuthenticationRequest;
import com.lysj.property.security.entity.JwtAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fupeng
 * @date 2019/1/25
 */
@RestController
public class AuthController extends BaseController {

    @Autowired
    AuthService authService;
    @Autowired
    JwtProperties jwtProperties;

    @PostMapping(value = "${property.jwt.route.authentication.register}")
    public SecurityUser register(SecurityUser addedUser) {
        return authService.register(addedUser);
    }

    @PostMapping(value = "${property.jwt.route.authentication.login}")
    public DataResponse<?> login(@RequestBody JwtAuthenticationRequest request) throws AuthenticationException {
        final String token = authService.login(request.getUsername(),request.getPassword());

        // Return the token
        return DataResponse.success(new JwtAuthenticationResponse(token));
    }

    @GetMapping(value = "${property.jwt.route.authentication.refresh}")
    public ResponseEntity<?> refreshToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(jwtProperties.getHeader());
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }
}
