package com.zzy.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
//@Aspect
@Component
public class TimerAspect {
    @Before("execution(public void com.zzy.service.OrderService.generate())")
    public void beforeAdvice() {
        System.out.println("前置通知");
    }

    @AfterReturning("execution(public void com.zzy.service.OrderService.generate())")
    public void afterAdvice() {
        System.out.println("后置通知");
    }

    @Around("execution(public void com.zzy.service.OrderService.generate())")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知");
        joinPoint.proceed();
        System.out.println("环绕后通知");
    }

    @AfterThrowing("execution(public void com.zzy.service.OrderService.generate())")
    public void exceptionAdvice() {
        System.out.println("产生异常");
    }

    @After("execution(public void com.zzy.service.OrderService.generate())")
    public void finalAdvice() {
        System.out.println("最终通知");
    }
}
