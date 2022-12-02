package com.zzy.instantiation.bean;

/**
 * 静态工厂
 */
public class StarFactory {
    /**
     * 获取明星实例
     * @return
     */
    public static Star getStar() {
        return new Star();
    }
}
