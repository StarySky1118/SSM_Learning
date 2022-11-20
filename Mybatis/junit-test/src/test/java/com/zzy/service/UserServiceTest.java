package com.zzy.service;

import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void testSum() {
        UserService userService = new UserService();

        // 实际值
        int actual = userService.sum(1, 2);
        // 期待值
        int expected = 3;
        // 断言判断
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSub() {

    }
}
