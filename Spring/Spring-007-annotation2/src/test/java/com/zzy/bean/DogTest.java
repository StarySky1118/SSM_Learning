package com.zzy.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogTest {
    @Test
    public void testAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Dog dogBean = applicationContext.getBean("dog", Dog.class);
        System.out.println(dogBean);
    }
}
