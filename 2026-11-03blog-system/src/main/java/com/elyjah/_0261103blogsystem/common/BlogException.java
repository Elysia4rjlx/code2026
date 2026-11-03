package com.elyjah._0261103blogsystem.common;


import lombok.Getter;

public class BlogException extends RuntimeException {
    @Getter
    private Integer code;
    private String message;

//    public BlogException(Integer code, String message) {
//        this.code = code;
//        this.message = message;
//    }
    public BlogException(Integer code, String message) {
        super(message);          // 让 getMessage() 能取到
        this.code = code;
    }

    public BlogException(String message) {
        this.message = message;
    }
}
