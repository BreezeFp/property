package com.lysj.property.admin.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lysj.property.entity.sys.Role;

import java.util.List;

public interface IRoleService extends IService<Role> {

    List<Role> getRoleByUserId(Long userId);

}
