package com.elyjah._026_10_01bookdemo.enums;

/**
 * 图书状态枚举
 */
public enum BookStatus {

    DELETED(0,"无效"),
    NORMAL(1, "可借阅"),
    FORBIDDEN(2, "不可借阅");

    private Integer code;
    private String name;

    BookStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static BookStatus getNameByCode(Integer code) {
        switch (code) {
            case 0:
                return DELETED;
            case 1:
                return NORMAL;
            case 2:
                return FORBIDDEN;
        }
        return null;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
