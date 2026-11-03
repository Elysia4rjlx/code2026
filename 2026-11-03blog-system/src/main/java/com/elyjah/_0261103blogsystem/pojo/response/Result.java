package com.elyjah._0261103blogsystem.pojo.response;

import com.elyjah._0261103blogsystem.common.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String errMsg;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(String errMsg) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setErrMsg(errMsg);
        return result;
    }

    public static <T> Result<T> unlogin(String errMsg) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.UNLOGIN.getCode());
        result.setErrMsg(ResultCodeEnum.UNLOGIN.getMessage());
        return result;
    }
}