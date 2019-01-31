package com.lysj.property.common;

import lombok.Data;

/**
 * @author fupeng
 * @date 2019/1/25
 */
@Data
public class DataResponse<T> extends BaseResponse {

    private T value;

}
