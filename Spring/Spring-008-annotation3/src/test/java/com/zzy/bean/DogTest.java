package com.zzy.bean;

import com.zzy.bean.impl.DogImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogTest {
    @Test
    public void testDog() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        DogImpl dogImpl = applicationContext.getBean("dogImpl", DogImpl.class);
        System.out.println(dogImpl);
    }
}
