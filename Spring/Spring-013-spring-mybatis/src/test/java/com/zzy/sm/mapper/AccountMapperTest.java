package com.zzy.sm.mapper;

import com.zzy.sm.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring.xml")
public class AccountMapperTest {
//    @Autowired
//    private AccountMapper accountMapper;

    @Test
    public void testInsert() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        AccountMapper bean = ac.getBean(AccountMapper.class);
        Account account = new Account(null, "004", BigDecimal.valueOf(1000));
        int count = bean.insert(account);
        System.out.println(count > 0 ? "插入成功！" : "插入失败");
    }
}
