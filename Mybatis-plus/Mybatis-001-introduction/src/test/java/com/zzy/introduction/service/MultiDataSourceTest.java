package com.zzy.introduction.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MultiDataSourceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    @Test
    public void test01() {
        System.out.println(userService.getById(1L));
        System.out.println(productService.getById(1L));
    }
}
