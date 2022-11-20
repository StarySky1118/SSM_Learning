package com.zzy.dynamic.mapper;

import com.zzy.dynamic.pojo.Car;
import com.zzy.dynamic.utils.MybatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarMapperTest {
    @Test
    public void testQueryByMultiConditions() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

//        List<Car> cars = mapper.queryByMultiConditions("宝", BigDecimal.valueOf(20), "新");
//        List<Car> cars = mapper.queryByMultiConditions(null, null, null);
        List<Car> cars = mapper.queryByMultiConditions("宝", null, "");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void testQueryByMultiConditionsWithWhere() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        List<Car> cars = mapper.queryByMultiConditionsWithWhere("", BigDecimal.valueOf(20), "");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void testQueryByMultiConditionsWithTrim() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        List<Car> cars = mapper.queryByMultiConditionsWithTrim("", null, null);
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void testUpdateByIdWithSet() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        Car car = new Car(187, null, "宝宝巴士", null, null, null);
        int count = mapper.updateByIdWithSet(car);
        sqlSession.commit();
        System.out.println(count > 0 ? "更新成功！" : "更新失败！");
    }

    @Test
    public void testQueryByBrand() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        List<Car> cars = mapper.queryByBrand("", null, "油");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void testDeleteByIds() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        Integer[] ids = {188, 189, 190};
        int count = mapper.deleteByIds(ids);
        sqlSession.commit();

        System.out.println("删除的记录条数为：" + count);
    }

    @Test
    public void testInsertCars() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(null, "1105", "特斯拉Model3", BigDecimal.valueOf(20), "2022-11-16", "电动车"));
        cars.add(new Car(null, "1105", "特斯拉Model3", BigDecimal.valueOf(20), "2022-11-16", "电动车"));
        cars.add(new Car(null, "1105", "特斯拉Model3", BigDecimal.valueOf(20), "2022-11-16", "电动车"));

        int count = mapper.insertCars(cars);

        sqlSession.commit();
        System.out.println("插入的记录条数为：" + count);
    }
}
