package com.zzy.dao.impl;

import com.zzy.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoMySQL implements OrderDao {
    @Override
    public void insert() {
        System.out.println("MySQL 数据库正在保存数据...");
    }
}
