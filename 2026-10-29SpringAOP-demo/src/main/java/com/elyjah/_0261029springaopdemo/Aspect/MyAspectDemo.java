package com.elyjah._0261029springaopdemo.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspectDemo {


    @Before("@annotation(com.elyjah._0261029springaopdemo.Aspect.MyAspect)")
    public void before() {
        log.info("MyAspect -> before ");
    }

    @After("@annotation(com.elyjah._0261029springaopdemo.Aspect.MyAspect)")
    public void after() {
        log.info("MyAspect -> after ");
    }
}