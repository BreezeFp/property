package com.lysj.property.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum  GenderEnum {

    UNKNOWN(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女");

    GenderEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @EnumValue
    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
