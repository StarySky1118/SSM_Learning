package com.zzy.DI.service;

import com.zzy.DI.dao.UserDao;
import com.zzy.DI.dao.VipDao;

public class MyService {
    private UserDao userDao;
    private VipDao vipDao;

    public MyService(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public void insertAll() {
        userDao.insert();
        vipDao.insert();
    }
}
