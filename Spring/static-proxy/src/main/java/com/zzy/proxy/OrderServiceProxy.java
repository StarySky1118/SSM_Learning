package com.zzy.proxy;

/**
 * 代理类
 */
public class OrderServiceProxy implements OrderService{
    private OrderService orderService;

    @Override
    public void generate() {
        /*
            增强代码
        */
        orderService.generate();
    }

    @Override
    public void detail() {

    }

    @Override
    public void delete() {

    }
}
