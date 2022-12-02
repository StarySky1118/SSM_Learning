package com.zzy.DI.dao;

import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testInsert() {
        UserDao userDao = new UserDao();
        userDao.insert();
    }
}
