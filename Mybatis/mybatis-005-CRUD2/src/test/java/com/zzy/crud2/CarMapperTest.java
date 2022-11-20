package com.zzy.crud2;

import com.zzy.crud2.mapper.CarMapper;
import com.zzy.crud2.pojo.Car;
import com.zzy.crud2.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class CarMapperTest {
    private SqlSession sqlSession = MybatisUtils.openSession();
    private CarMapper carMapper = sqlSession.getMapper(CarMapper.class);

    @Test
    public void testInsert() {
        Car car = new Car(null, "1104", "XiaoMi 10", BigDecimal.valueOf(4999), "2022-11-13", "燃油");
        int count = carMapper.insert(car);
        System.out.println(count > 0 ? "插入成功！" : "插入失败！");
        sqlSession.commit();
    }

    @Test
    public void testDeleteById() {
        int count = carMapper.deleteById(185);
        System.out.println(count > 0 ? "删除成功！" : "删除失败！");
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        Car car = new Car(186, "1104", "XiaoMi 10", BigDecimal.valueOf(3999), "2022-11-13", "燃油");
        int count = carMapper.update(car);
        System.out.println(count > 0 ? "更新成功！" : "更新失败");
        sqlSession.commit();
    }

    @Test
    public void testQueryOneById() {
        Car car = carMapper.queryOneById(186);
        System.out.println(car);
    }

    @Test
    public void testQueryAllById() {
        List<Car> cars = carMapper.queryAll();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void testQueryAllByPrice() {
        List<Car> cars = carMapper.queryAllByPrice("ASC");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void testDeleteBatchById() {
        int count = carMapper.deleteBatchById("176, 177, 178");
        System.out.println("删除的记录条数为：" + count);
        sqlSession.commit();
    }

    @Test
    public void testQueryLike() {
        List<Car> cars = carMapper.queryLike("宝");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void testInsertAndGetKey() {
        Car car = new Car(null, "1104", "XiaoMi 10", BigDecimal.valueOf(4999), "2022-11-13", "燃油");
        int count = carMapper.insertAndGetKey(car);
        sqlSession.commit();
        System.out.println("自增主键值：" + car.getId());
    }
}
