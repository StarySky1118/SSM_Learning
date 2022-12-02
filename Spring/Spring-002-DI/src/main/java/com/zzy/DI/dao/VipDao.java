package com.zzy.DI.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VipDao {
    private static final Logger logger = LoggerFactory.getLogger(VipDao.class);

    public void insert() {
        logger.info("vip 用户信息插入成功！");
    }
}
