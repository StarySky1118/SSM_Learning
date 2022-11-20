package com.zzy.annotation.mapper;

import com.zzy.annotation.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CarMapper {
    @Insert("insert into t_car values (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})")
    int insert(Car car);

    @Delete("delete from t_car where id = #{id}")
    int deleteById(Long id);

    @Select("select * from t_car")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "carNum", column = "car_num"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "guidePrice", column = "guide_price"),
            @Result(property = "produceTime", column = "produce_time"),
            @Result(property = "carType", column = "car_type")
    })
    List<Car> queryAll();
}
