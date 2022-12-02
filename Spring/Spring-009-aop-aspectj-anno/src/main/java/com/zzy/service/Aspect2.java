package com.zzy.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspect2 {
    @Order(2)
    @Before("com.zzy.service.Aspect1.generalPointCut()")
    public void beforeAdvice() {
        System.out.println("Aspect2 前置通知");
    }
}
