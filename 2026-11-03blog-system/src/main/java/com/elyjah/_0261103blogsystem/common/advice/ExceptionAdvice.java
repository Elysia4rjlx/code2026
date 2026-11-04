package com.elyjah._0261103blogsystem.common.advice;


import com.elyjah._0261103blogsystem.common.enums.ResultCodeEnum;
import com.elyjah._0261103blogsystem.common.exception.BlogException;
import com.elyjah._0261103blogsystem.pojo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public Result handler(Exception e) {
        log.error("发生异常,e",e);
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler
    public Result handler(BlogException e) {
        log.error("发生异常,e",e);
        return Result.fail(e.getCode(),e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HandlerMethodValidationException.class)  // 登记：这类交给下面这个方法
    public Result handler(HandlerMethodValidationException e) {
        List<String> errors = new ArrayList<>();                // 准备装写的中文提示

        e.getAllErrors().forEach(error ->     // 翻开异常自带的明细单
                errors.add(error.getDefaultMessage()));         //    一条条抄出 @NotNull(message=...) 里的中文

        String msg = errors.isEmpty()                           // 万一是空的给个兜底
                ? "参数校验失败"
                : String.join(", ", errors);

        log.error("参数校验失败: {}", msg);                      // 往后台日志记

        return Result.fail(ResultCodeEnum.PARAM_ERROR, msg);   //code 用 400，内容是写的中文
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)   //登记：blogId 传了非数字时抛它
    public Result handler(MethodArgumentTypeMismatchException e) {
        log.error("参数类型错误: {}", e.getMessage());
        return Result.fail(ResultCodeEnum.PARAM_ERROR, "blogId 必须是数字");  // ④ code 也是 400
    }

    /**
     * 处理 @RequestBody 上 @Valid 校验失败的情况（登录接口用）。
     * <p>
     * 注意区分两种异常：
     * MethodArgumentNotValidException —— 请求体里的对象校验失败（@Valid @RequestBody）
     * HandlerMethodValidationException —— 方法参数上的约束校验失败（如 @NotNull Integer blogId）
     * 两种都要单独登记，否则登录参数校验会返回 500 而不是 400。
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
                errors.add(error.getDefaultMessage()));

        String msg = errors.isEmpty()
                ? "参数校验失败"
                : String.join(", ", errors);

        log.error("参数校验失败: {}", msg);

        return Result.fail(ResultCodeEnum.PARAM_ERROR, msg);
    }

}
