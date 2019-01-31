package com.lysj.property.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author fupeng
 * @date 2019/1/19
 */
@EqualsAndHashCode(callSuper = true)
@Data(staticConstructor = "of")
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role extends Model<Role> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String code;

    private String name;

    private String remark;

}
