package com.lysj.property.common;

import lombok.Data;

/**
 * @author fupeng
 * @date 2019/1/25
 */
@Data
public class BaseResponse {

    protected Integer statusCode;

    protected String statusMsg;

}
