package com.zzy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class SecurityAspect {
    // 切点
    @Pointcut("execution(* com.zzy.service..insert*(..))")
    public void insertPointcut(){}

    @Pointcut("execution(* com.zzy.service..delete*(..))")
    public void deletePointcut(){}

    @Pointcut("execution(* com.zzy.service..update*(..))")
    public void updatePointcut(){}

    // 通知
    @Before("insertPointcut() || deletePointcut() || updatePointcut()")
    public void recordAction(JoinPoint joinPoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(new Date());
        System.out.println(nowTime + "张三" + joinPoint.getSignature().getName());
    }
}
