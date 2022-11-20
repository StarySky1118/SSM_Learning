package com.zzy001.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        // 获取 sqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 获取 sqlSessionFactory 对象，一般是一个数据库对应一个
        // Resources.getResourceAsStream 默认从类的根路径开始查找
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        // 获取 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行 sql 语句
        int count = sqlSession.insert("insertCar");

        System.out.println(count > 0 ? "插入成功！" : "插入失败！");

        // 手动提交
        sqlSession.commit();
    }
}
