package com.zzy001.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 一个比较完整的 MyBatis 程序
 */
public class MyBatisComplete {
    public static void main(String[] args) {
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
}
