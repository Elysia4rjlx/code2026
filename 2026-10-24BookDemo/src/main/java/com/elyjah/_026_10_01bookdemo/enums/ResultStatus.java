package com.elyjah._026_10_01bookdemo.enums;

public enum ResultStatus {
    SUCCESS(200),
    UNLOGIN(-1),
    FAIL(-2);

    private Integer code;

    ResultStatus(Integer code) {
        this.code = code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}