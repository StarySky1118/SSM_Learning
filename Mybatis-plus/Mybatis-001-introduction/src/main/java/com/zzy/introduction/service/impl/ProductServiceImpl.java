package com.zzy.introduction.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.introduction.mapper.ProductMapper;
import com.zzy.introduction.pojo.Product;
import com.zzy.introduction.service.ProductService;
import org.springframework.stereotype.Service;

@DS("slave_1") // 指定操作 slave_1 数据源
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
