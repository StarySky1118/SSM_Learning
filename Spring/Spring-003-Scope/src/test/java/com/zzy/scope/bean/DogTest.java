package com.zzy.scope.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogTest {
    @Test
    public void testScope() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }
}
