package com.zzy.smt.mapper;

import com.zzy.smt.pojo.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    int insert(Account account);
}
