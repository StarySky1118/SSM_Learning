package com.zzy.dynamic.proxy;

/**
 * 目标类
 */
public class OrderServiceImpl implements OrderService{
    @Override
    public void generate() {
        System.out.println("订单已生成。");
    }

    @Override
    public void detail() {
        System.out.println("订单详情如下。");
    }

    @Override
    public void delete() {
        System.out.println("订单已删除。");
    }
}
