//package com.elyjah._0261029springaopdemo.exercise;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Order(2)
//@Slf4j
//public class Exercise2LogAspect {
//
//    @Pointcut("execution(* com.elyjah._0261029springaopdemo.Controller..*.*(..))")
//    public void cp() {}
//
//    @Before("cp()")
//    public void before (JoinPoint joinPoint){
//        log.info("Before2  :{}",joinPoint.getSignature().toShortString());
//    }
//    @After("cp()")
//    public void after (JoinPoint joinPoint){
//        log.info("after2  :{}",joinPoint.getSignature().toShortString());
//    }
//
//
//}
