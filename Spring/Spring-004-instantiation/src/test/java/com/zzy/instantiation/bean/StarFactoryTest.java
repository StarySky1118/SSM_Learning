package com.zzy.instantiation.bean;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StarFactoryTest {
    @Test
    public void testStatic() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("static-factory.xml");
        Star star = applicationContext.getBean("star", Star.class);

        System.out.println(star);
    }

    @Test
    public void testMethod() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("method-factory.xml");
        Gun gunBean = applicationContext.getBean("gunBean", Gun.class);

        System.out.println(gunBean);
    }

    @Test
    public void testInterface() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("interface-factory.xml");
        Person person = applicationContext.getBean("person", Person.class);

        System.out.println(person);
    }

    @Test
    public void testDate() throws ParseException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("interface-factory.xml");
        Person person = applicationContext.getBean("person", Person.class);

        System.out.println(person);
    }

    @Test
    public void testRegister() {
        Gun gun = new Gun();
        System.out.println(gun);

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerSingleton("gunBean", gun);
        Gun gunBean = defaultListableBeanFactory.getBean("gunBean", Gun.class);
        System.out.println(gunBean);
    }
}
