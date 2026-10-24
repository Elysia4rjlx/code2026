package com.elyjah._026_10_01bookdemo.common;

import com.elyjah._026_10_01bookdemo.enums.ResultStatus;
import lombok.Data;

@Data
public class Result<T> {
    private ResultStatus status; // 业务状态：成功/未登录/失败
    private String errorMessage; //失败原因，成功是空串
    private T data; //真正的业务数据


    /**
     * 业务执行成功
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.SUCCESS);
        result.setErrorMessage("");
        result.setData(data);
        return result;
    }

    /**
     * 业务执行失败
     */
    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.FAIL);
        result.setErrorMessage(msg);
        result.setData(null);
        return result;
    }

    /**
     * 用户未登录
     */
    public static <T> Result<T> unlogin() {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.UNLOGIN);
        result.setErrorMessage("用户未登录");
        result.setData(null);
        return result;
    }
}