package com.zzy.introduction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.introduction.pojo.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
