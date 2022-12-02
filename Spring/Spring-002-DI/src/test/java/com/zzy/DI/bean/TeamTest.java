package com.zzy.DI.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TeamTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-array.xml");
        Team lakers = applicationContext.getBean("lakersBean", Team.class);
        System.out.println(lakers);
    }
}
