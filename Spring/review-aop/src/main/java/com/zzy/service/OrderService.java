package com.zzy.service;

import org.springframework.stereotype.Service;

/**
 * 目标类
 */
@Service
public class OrderService {
    public void generate() throws InterruptedException {
        Thread.sleep(2345);
        System.out.println("订单已生成");
    }
}
