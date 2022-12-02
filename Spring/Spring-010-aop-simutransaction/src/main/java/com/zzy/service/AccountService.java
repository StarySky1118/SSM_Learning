package com.zzy.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public void transfer() {
        int i = 10 / 0;
        System.out.println("账户正在转账");
    }
}
