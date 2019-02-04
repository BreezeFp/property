package com.lysj.property.dao.sys;

import com.baomidou.mybatisplus.core.mapper.*;
import com.lysj.property.entity.sys.*;
import org.apache.ibatis.annotations.*;

/**
 * @author fupeng
 * @date 2019/1/25
 */
public interface RoleMapper extends BaseMapper<Role> {
    
    @Insert(value = "insert into sys_user_role (user_id, role_id) values(#{userId}, (select id from sys_role where code = 'user'))")
    void addDefaultRole(@Param("userId") Long userId);
    
}
