package com.zzy.smt.service.impl;

import com.zzy.smt.mapper.AccountMapper;
import com.zzy.smt.pojo.Account;
import com.zzy.smt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // 将 AccountServiceImpl 纳入 Spring 容器管理
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public AccountMapper getAccountMapper() {
        return accountMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public int save(Account account) {
        return accountMapper.insert(account);
    }
}
