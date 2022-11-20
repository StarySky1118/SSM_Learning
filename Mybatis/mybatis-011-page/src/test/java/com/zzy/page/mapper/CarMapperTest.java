package com.zzy.page.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.page.pojo.Car;
import com.zzy.page.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        PageHelper.startPage(2, 3);

        List<Car> cars = mapper.selectAll();

        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 4);
        System.out.println(carPageInfo);
        sqlSession.close();
    }
}
