package com.zzy.annotation.mapper;

import com.zzy.annotation.pojo.Car;
import com.zzy.annotation.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;

public class CarMapperTest {
    @Test
    public void testInsert() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        int count = mapper.insert(new Car(null, "1111", "保时捷", BigDecimal.valueOf(1000), "2022-11-20", "燃油车"));
        sqlSession.commit();
        System.out.println(count > 0 ? "插入成功！" : "插入失败！");
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        int count = mapper.deleteById(197L);
        sqlSession.commit();
        System.out.println(count > 0 ? "删除成功！" : "删除失败！");
    }
}
