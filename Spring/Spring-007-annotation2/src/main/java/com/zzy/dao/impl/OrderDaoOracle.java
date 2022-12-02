package com.zzy.dao.impl;

import com.zzy.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoOracle implements OrderDao {

    @Override
    public void insert() {
        System.out.println("Oracle 数据库正在保存信息...");
    }
}
