package com.zzy.page.mapper;

import com.zzy.page.pojo.Car;
import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Car row);

    Car selectByPrimaryKey(Long id);

    List<Car> selectAll();

    int updateByPrimaryKey(Car row);
}