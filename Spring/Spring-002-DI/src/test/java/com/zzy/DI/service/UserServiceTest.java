package com.zzy.DI.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void testInsertUser() {
        // 启用 Spring 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // 获取 bean 对象
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.insertUser();
    }

    @Test
    public void testAutowireByName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowire.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        userService.insertUser();
    }
}
