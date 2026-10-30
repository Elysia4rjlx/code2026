package com.elyjah._0261029springaopdemo.exerciseTest;

import com.elyjah._0261029springaopdemo.exception.NotLoginException;
import jakarta.servlet.ServletRequestAttributeEvent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order
@Slf4j
public class Exercise2AuthAspect {

    @Pointcut("execution(* com.elyjah._0261029springaopdemo.Controller.BookController.*(..))")
    public void cp(){}

    @Before("cp()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        String token = null;

        if (attributes != null) {
            token = attributes.getRequest().getHeader("token");
        }

        if ("admin".equals(token)) {
            log.info("练习2-登录校验] token= {} .用户=管理员" ,token);
        }else if ("zhangsan".equals(token)) {
            log.info("练习2-登录校验] token= {} 用户 = 张三" ,token);
        }else {
            throw new NotLoginException("未登录");
        }
    }
}