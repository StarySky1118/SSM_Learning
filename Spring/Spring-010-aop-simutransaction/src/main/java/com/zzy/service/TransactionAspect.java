package com.zzy.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 事务处理切面
 */
@Component
@Aspect
public class TransactionAspect {
    // 定义通用切点
    @Pointcut("execution(* com.zzy.service..*(..))")
    public void generalCutPoint() {

    }

    @Around("generalCutPoint()")
    public void transactionManage(ProceedingJoinPoint joinPoint) {
        try {
            // 开启事务
            System.out.println("开启事务");
            // 执行业务代码
            joinPoint.proceed();
            // 提交事务
            System.out.println("提交事务");
        } catch (Throwable e) {
           // 事务回滚
            System.out.println("事务回滚");
        }
    }
}
