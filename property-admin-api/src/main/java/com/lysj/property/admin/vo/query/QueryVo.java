package com.lysj.property.admin.vo.query;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QueryVo<T> {

    private T item;

}
