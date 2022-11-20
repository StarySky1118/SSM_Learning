package com.zzy.generator02.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Mybatis 工具类
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 类加载时，创建 sqlSessionFactory
     */
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 构造方法私有化
    private MybatisUtils() {
    }

    /**
     * 开启 sql 会话
     * @return sql 会话
     */
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }
}
