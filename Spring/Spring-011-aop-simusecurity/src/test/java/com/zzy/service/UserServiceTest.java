package com.zzy.service;

import com.zzy.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceTest {
    @Test
    public void testSecurity() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUser();
        userService.insertUser();
        userService.deleteUser();
        userService.updateUser();
    }
}
