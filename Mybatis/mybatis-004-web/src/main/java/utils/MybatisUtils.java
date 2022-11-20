package utils;

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
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

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
        // 首先在 threadLocal 对象中获取
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) { // 第一次连接数据库
            // 获取数据库连接并放入 ThreadLocal 对象
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 将连接放回连接池并取消绑定
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            // 归还连接
            sqlSession.close();
            // 解绑
            threadLocal.remove();
        }
    }
}
