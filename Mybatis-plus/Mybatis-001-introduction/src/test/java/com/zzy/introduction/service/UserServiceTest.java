package com.zzy.introduction.service;

import com.zzy.introduction.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testList() {
        List<User> list = userService.list();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
