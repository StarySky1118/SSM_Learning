package com.zzy.ssm.mapper;

import com.zzy.ssm.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    int insert(Account account);
}
