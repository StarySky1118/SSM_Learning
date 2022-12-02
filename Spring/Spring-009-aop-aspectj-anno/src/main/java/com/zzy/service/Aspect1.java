package com.zzy.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspect1 {
    @Pointcut("execution(public void com.zzy.service.OrderService.generate())")
    public void generalPointCut() {

    }

    @Order(1)
    @Before("generalPointCut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Aspect1 前置通知");
        System.out.println("目标方法名：" + joinPoint.getSignature().getName());
    }
}
