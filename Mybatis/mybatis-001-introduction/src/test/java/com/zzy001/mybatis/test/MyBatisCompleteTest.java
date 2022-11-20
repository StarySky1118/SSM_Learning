package com.zzy001.mybatis.test;

import com.zzy001.mybatis.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class MyBatisCompleteTest {
    @Test
    public void test01() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = null;
        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession(); // 开启事务

            // 执行业务
            int count = sqlSession.insert("insertCar");
            System.out.println(count > 0 ? "添加成功！" : "添加失败");

            // 事务提交
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
            // 事务回滚
            sqlSession.rollback();
        } finally {
            // 关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void test02() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtils.openSession(); // 开启事务

            // 执行业务
            int count = sqlSession.insert("insertCar");
            System.out.println(count > 0 ? "添加成功！" : "添加失败");

            // 事务提交
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            // 事务回滚
            sqlSession.rollback();
        } finally {
            // 关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
