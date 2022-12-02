package com.zzy.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void insertUser() {
        System.out.println("正在保存用户信息...");
    }

    public void deleteUser() {
        System.out.println("正在删除用户信息...");
    }

    public void updateUser() {
        System.out.println("正在更新用户信息...");
    }

    public void queryUser() {
        System.out.println("正在查询用户信息...");
    }
}
