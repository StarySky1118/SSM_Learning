package com.zzy.ssm.mapper;

import com.zzy.ssm.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application_context_mapper.xml")
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testInsert() {
        Account account = new Account(null, "004", BigDecimal.valueOf(1000));
        int count = accountMapper.insert(account);
        System.out.println(count);
    }
}
