//package com.elyjah._0261029springaopdemo.Aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Aspect
//@Component
//@Order(1)
//public class AspectDemo3 {
//
//    //前置通知
//    @Before("com.elyjah._0261029springaopdemo.Aspect.AspectDemo2.pt()")
//    public void doBefore() {
//        log.info("执⾏ Before3 ⽅法");
//    }
//
//    //返回后通知
//    @After("execution(* com.elyjah._0261029springaopdemo.Controller.*.*(..))")
//    public void doAfter() {
//        log.info("执⾏ After3 ⽅法");
//    }
//
//    //返回后通知
//    @AfterReturning("execution(* com.elyjah._0261029springaopdemo.Controller.*.*(..))")
//    public void doAfterReturning() {
//        log.info("执⾏ AfterReturning3 ⽅法");
//    }
//
//    //抛出异常后通知
//    @AfterThrowing("execution(* com.elyjah._0261029springaopdemo.Controller.*.*(..))")
//    public void doAfterThrowing() {
//        log.info("执⾏ doAfterThrowing3 ⽅法");
//    }
//
//    @Around("execution(* com.elyjah._0261029springaopdemo.Controller.*.*(..))")
//    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("Around3 方法开始执行");
//        Object result = joinPoint.proceed();
//        log.info("Around3 方法结束执行");
//        return result;
//    }
//}