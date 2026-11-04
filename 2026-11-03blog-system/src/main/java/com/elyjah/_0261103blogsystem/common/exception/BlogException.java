package com.elyjah._0261103blogsystem.common.exception;


import com.elyjah._0261103blogsystem.common.enums.ResultCodeEnum;
import lombok.Getter;

@Getter
public class BlogException extends RuntimeException {

    private ResultCodeEnum code;
//    private String message;


    public BlogException(ResultCodeEnum code,String message) {
        super(message);
        this.code = code;
    }

    public BlogException(ResultCodeEnum code) {
        super(code.getMessage());
        this.code = code;
    }

    public BlogException(String message) {
        super(message);
        this.code = ResultCodeEnum.FAIL;
    }
}
