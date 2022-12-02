package com.zzy.service;

import com.zzy.dao.OrderDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Resource(name = "orderDaoOracle")
    private OrderDao orderDao;

    public void generateOrder() {
        orderDao.insert();
    }
}
