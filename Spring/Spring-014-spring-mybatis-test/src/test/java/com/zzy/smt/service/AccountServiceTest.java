package com.zzy.smt.service;

import com.zzy.smt.pojo.Account;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class AccountServiceTest {
    @Test
    public void testSave() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        SqlSessionFactoryBean sqlSessionFactoryBean = ac.getBean("sqlSessionFactoryBean", SqlSessionFactoryBean.class);
//        System.out.println(sqlSessionFactoryBean);
//        AccountService accountService = ac.getBean("accountService", AccountService.class);
//        int count = accountService.save(new Account(null, "004", BigDecimal.valueOf(1000)));
//        System.out.println(count > 0 ? "插入失败！" : "保存失败！");
    }
}
