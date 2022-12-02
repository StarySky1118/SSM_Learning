package com.zzy.DI.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-map.xml");
        Person jackBean = applicationContext.getBean("jackBean", Person.class);

        System.out.println(jackBean);
    }
}
