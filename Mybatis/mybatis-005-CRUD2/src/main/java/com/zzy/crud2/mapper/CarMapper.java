package com.zzy.crud2.mapper;

import com.zzy.crud2.pojo.Car;

import java.util.List;

public interface CarMapper {
    /**
     * 添加汽车
     * @param car 汽车对象
     * @return 受影响的记录条数
     */
    int insert(Car car);

    /**
     * 删除汽车
     * @param id 汽车编号
     * @return 受影响的记录条数
     */
    int deleteById(Integer id);

    /**
     * 更新汽车信息
     * @param car 汽车对象
     * @return 受影响的记录条数
     */
    int update(Car car);

    /**
     * 查询单个汽车信息
     * @param id 汽车编号
     * @return 汽车对象
     */
    Car queryOneById(Integer id);

    /**
     * 查询所有汽车信息
     * @return 汽车列表
     */
    List<Car> queryAll();

    /**
     * 查询所有汽车信息并进行排序
     * @param order 值为 ASC/DESC
     * @return 排序的汽车列表
     */
    List<Car> queryAllByPrice(String order);

    /**
     * 通过 id 批量删除记录
     * @param ids id 集合
     * @return 删除的记录条数
     */
    int deleteBatchById(String ids);

    /**
     * 通过品牌进行模糊查询
     * @param brand 品牌
     * @return 车辆列表
     */
    List<Car> queryLike(String brand);

    /**
     * 插入记录并获取自动递增的主键值
     * @param car pojo 对象
     * @return 插入的记录条数
     */
    int insertAndGetKey(Car car);
}
