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
//@Order(2)
//public class AspectDemo2 {
//
//    //定义一个切点：一个空的，没有方法体的方法，作用只是“起个名字”存表达式
//    @Pointcut("execution(* com.elyjah._0261029springaopdemo.Controller.*.*(..))")
//    public void pt(){}
//
//    //直接引用pt()
//    @Before("pt()")
//    public void doBefore() {
//        log.info("执⾏ Before2 ⽅法");
//    }
//
//
//    //返回后通知
//    @After("pt()")
//    public void doAfter() {
//        log.info("执⾏ After2 ⽅法");
//    }
//
//    //返回后通知
//    @AfterReturning("pt()")
//    public void doAfterReturning() {
//        log.info("执⾏ AfterReturning2 ⽅法");
//    }
//
//    //抛出异常后通知
//    @AfterThrowing("pt()")
//    public void doAfterThrowing() {
//        log.info("执⾏ doAfterThrowing2 ⽅法");
//    }
//
//    @Around("pt()")
//    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("Around2 方法开始执行");
//        Object result = joinPoint.proceed();
//        log.info("Around2 方法结束执行");
//        return result;
//    }
//
//
//
//
//
//
//
//
//}