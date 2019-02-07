package com.lysj.property.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lysj.property.entity.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author fupeng
 * @date 2019/1/19
 */
@Data(staticConstructor = "of")
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;
    
    private String password;

    private String nickname;

    private GenderEnum gender;

    private Date lastPasswordResetDate;

    private boolean locked;

    private Long remover;

    private Date removed;
}
