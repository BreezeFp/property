package com.lysj.property.admin.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lysj.property.entity.sys.Role;
import com.lysj.property.entity.sys.User;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * @author fupeng
 * @date 2019/1/26
 */
@Data(staticConstructor = "of")
@JsonIgnoreProperties({"user.password"})
public class UserVo {

    @NonNull
    private User user;

    private List<Role> roles;
}
