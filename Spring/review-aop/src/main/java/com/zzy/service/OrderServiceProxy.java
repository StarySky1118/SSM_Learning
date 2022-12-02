package com.zzy.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 代理类
 */
@Component
@Aspect
public class OrderServiceProxy {
    @Around("execution(* com.zzy.service..*(..))")
    public void timeCount(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}
