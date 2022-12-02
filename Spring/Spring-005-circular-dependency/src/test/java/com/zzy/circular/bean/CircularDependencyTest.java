package com.zzy.circular.bean;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {
    @Test
    public void testSingleton_Setter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("singleton_setter.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println(husband);
        System.out.println(wife);

    }
}
