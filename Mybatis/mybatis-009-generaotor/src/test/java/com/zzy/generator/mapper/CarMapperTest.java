package com.zzy.generator.mapper;


import com.zzy.generator.pojo.Car;
import com.zzy.generator.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {
    @Test
    public void testSelectByPrimaryKey() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        Car car = mapper.selectByPrimaryKey(1L);
        System.out.println(car);
    }
}
