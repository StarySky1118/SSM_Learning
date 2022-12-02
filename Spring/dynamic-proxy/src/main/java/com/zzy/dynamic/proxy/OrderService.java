package com.zzy.dynamic.proxy;

/**
 * 公共接口
 */
public interface OrderService {
    /**
     * 生成订单
     */
    void generate();

    /**
     * 订单详情
     */
    void detail();

    /**
     * 删除订单
     */
    void delete();
}
