package com.zzy.sm.mapper;

import com.zzy.sm.pojo.Account;

public interface AccountMapper {
    /**
     * 新增账户
     * @param account 账户对象
     * @return 插入的记录数
     */
    int insert(Account account);
}
