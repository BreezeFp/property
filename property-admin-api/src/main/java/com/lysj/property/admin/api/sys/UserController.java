package com.lysj.property.admin.api.sys;

import com.lysj.property.admin.api.BaseController;
import com.lysj.property.admin.service.sys.IRoleService;
import com.lysj.property.admin.service.sys.IUserService;
import com.lysj.property.admin.vo.UserVo;
import com.lysj.property.admin.vo.query.QueryVo;
import com.lysj.property.common.DataResponse;
import com.lysj.property.entity.sys.Role;
import com.lysj.property.entity.sys.User;
import com.lysj.property.security.util.SecurityKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fupeng
 * @date 2019/1/19
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @GetMapping("")
    public DataResponse<User> me() {
        User user = SecurityKit.getUser();
        return DataResponse.success(user);
    }

    @GetMapping("/{id:\\d}")
    public DataResponse<UserVo> getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        List<Role> roles = roleService.getRoleByUserId(user.getId());
        UserVo userVo = UserVo.of(user);
        userVo.setRoles(roles);
        return DataResponse.success(UserVo.of(user));
    }

    @GetMapping("/list")
    public DataResponse<List<UserVo>> list(QueryVo<User> userQueryVo) {
        log.debug(userQueryVo.toString());
        return DataResponse.success(new ArrayList<>());
    }
}
