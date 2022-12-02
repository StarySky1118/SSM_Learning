package com.zzy.DI.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogTest {
    @Test
    public void testP() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("p-bean.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);

        System.out.println(dogBean);
    }
}
