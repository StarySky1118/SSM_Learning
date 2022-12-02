package com.zzy.DI.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServiceTest {
    @Test
    public void testInsertAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        MyService myService = applicationContext.getBean("myService", MyService.class);

        myService.insertAll();
    }
}
