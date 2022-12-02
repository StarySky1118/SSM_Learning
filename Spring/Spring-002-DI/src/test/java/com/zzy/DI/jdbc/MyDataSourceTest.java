package com.zzy.DI.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyDataSourceTest {
    @Test
    public void testUtil() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jdbcBean.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);

        System.out.println(ds1);
    }

    @Test
    public void testProperty() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("property-bean.xml");
        MyDataSource3 ds3 = applicationContext.getBean("ds3", MyDataSource3.class);

        System.out.println(ds3);
    }
}
