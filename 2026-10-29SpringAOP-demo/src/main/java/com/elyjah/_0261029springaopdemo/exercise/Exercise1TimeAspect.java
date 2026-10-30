package com.elyjah._0261029springaopdemo.exercise;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
@Slf4j
public class Exercise1TimeAspect {

    @Pointcut("execution(* com.elyjah._0261029springaopdemo.Controller.BookController.*(..))")
    public void bookPointcut() {}

//    @Around("bookPointcut()")

//    @Around("execution(* com.elyjah._0261029springaopdemo.controller..*.*(..))")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//
//        Object result = joinPoint.proceed();
//        long end = System.currentTimeMillis();
//        log.info(joinPoint.getSignature() + "执行耗时：{} ms " , end - start );
//        System.out.println("[练习1-耗时] " +
//                joinPoint.getSignature().toShortString() + " 耗时 " + (end - start) + "ms");
//        return result;
//    }

    @Around("bookPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();

        try {
            // 把目标方法的返回值透传出去
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            // 用 finally 保证异常场景也能统计到耗时
            long cost = System.currentTimeMillis() - start;
            log.info("[练习1-耗时] {} 耗时 {}ms",
                    joinPoint.getSignature().toShortString(), cost);
        }
    }
    }
}