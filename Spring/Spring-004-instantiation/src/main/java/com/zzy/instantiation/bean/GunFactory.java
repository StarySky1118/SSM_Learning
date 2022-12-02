package com.zzy.instantiation.bean;

/**
 * 具体工厂
 */
public class GunFactory {
    public Gun getGun() {
        return new Gun();
    }
}
