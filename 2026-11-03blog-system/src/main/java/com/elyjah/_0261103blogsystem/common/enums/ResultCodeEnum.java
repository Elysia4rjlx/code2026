package com.elyjah._0261103blogsystem.common.enums;

import lombok.Getter;

public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    PARAM_ERROR(400, "参数错误"),
    UNLOGIN(401, "未登录"),
    FORBIDDEN(403, "无权限"),
    FAIL(500, "服务器错误"),
    ;

    @Getter
    private final Integer code;
    @Getter
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

//    public Integer getCode() {
//        return code;
//    }

//    public String getMessage() {
//        return message;
//    }
}

