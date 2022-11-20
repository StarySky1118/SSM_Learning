package com.zzy.dynamic.mapper;

import com.zzy.dynamic.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CarMapper {
    /**
     * 批量插入记录
     * @param cars 汽车列表
     * @return 插入的记录条数
     */
    int insertCars(@Param("cars") List<Car> cars);

    /**
     * 根据 id 数据删除元素
     * @param ids id 数组
     * @return 删除的记录条数
     */
    int deleteByIds(@Param("ids") Integer[] ids);

    /**
     * 首先使用 brand 进行查询，如果 brand 不存在；使用 guidePrice 进行查询，以此类推。
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> queryByBrand(@Param("brand") String brand, @Param("guidePrice") BigDecimal guidePrice, @Param("carType") String carType);

    /**
     * 使用 set 标签通过 id 更新记录
     * @param car
     * @return
     */
    int updateByIdWithSet(Car car);

    /**
     * 使用 trim 标签进行动态 SQL 查询
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> queryByMultiConditionsWithTrim(@Param("brand") String brand, @Param("guidePrice") BigDecimal guidePrice, @Param("carType") String carType);

    /**
     * 使用 where 标签根据多个条件查询汽车列表
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> queryByMultiConditionsWithWhere(@Param("brand") String brand, @Param("guidePrice") BigDecimal guidePrice, @Param("carType") String carType);


    /**
     * 根据多个条件查询汽车
     * @param brand 品牌
     * @param guidePrice 指导价
     * @param carType 汽车类型
     * @return 汽车列表
     */
    List<Car> queryByMultiConditions(@Param("brand") String brand, @Param("guidePrice") BigDecimal guidePrice, @Param("carType") String carType);
}
