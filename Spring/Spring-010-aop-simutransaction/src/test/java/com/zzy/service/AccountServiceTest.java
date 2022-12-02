package com.zzy.service;

import com.zzy.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountServiceTest {
    @Test
    public void testTransfer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.transfer();

    }
}
