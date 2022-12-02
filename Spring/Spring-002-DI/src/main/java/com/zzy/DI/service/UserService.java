package com.zzy.DI.service;

import com.zzy.DI.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insertUser() {
        userDao.insert();
    }
}
