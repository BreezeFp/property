package com.lysj.property.admin.api.sys;

import com.lysj.property.admin.service.sys.IUserService;
import com.lysj.property.admin.vo.UserVo;
import com.lysj.property.entity.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fupeng
 * @date 2019/1/19
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/user/{id}")
    public Object getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        return UserVo.of(user);
    }
}
