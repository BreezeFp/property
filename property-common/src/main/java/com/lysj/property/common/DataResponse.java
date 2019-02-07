package com.lysj.property.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fupeng
 * @date 2019/1/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DataResponse<T> extends BaseResponse {

    private T value;

    public static <T> DataResponse<T> success(T value) {
        DataResponse<T> response = new DataResponse<>();
        response.setValue(value);
        response.setStatusCode(200);
        response.setStatusMsg("操作成功！");
        return response;
    }
}
