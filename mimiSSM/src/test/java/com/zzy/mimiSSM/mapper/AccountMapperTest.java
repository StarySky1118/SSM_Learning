package com.zzy.mimiSSM.mapper;

import com.zzy.mimiSSM.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_dao.xml")
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testInsert() {
        Account account = new Account(null, "004", BigDecimal.valueOf(1000));
        int count = accountMapper.insert(account);
        System.out.println(count > 0 ? "插入成功！" : "插入失败！");
    }
}
