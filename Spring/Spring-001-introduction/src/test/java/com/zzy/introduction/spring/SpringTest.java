package com.zzy.introduction.spring;

import com.zzy.introduction.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void testSpring() {
        // 初始化 Spring 容器上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Object userBean = applicationContext.getBean("userBean");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }
}
