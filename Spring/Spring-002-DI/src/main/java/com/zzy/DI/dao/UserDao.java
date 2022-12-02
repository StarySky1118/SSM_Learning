package com.zzy.DI.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {
    // 日志对象
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert() {
        logger.info("用户数据插入成功！");
    }
}
