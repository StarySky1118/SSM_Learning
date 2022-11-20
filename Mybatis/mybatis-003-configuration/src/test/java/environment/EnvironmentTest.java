package environment;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.MybatisUtils;

import java.io.IOException;

public class EnvironmentTest {
    @Test
    public void testEnvironment() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 默认数据库对应的 sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));

        // 指定数据库对应的 sqlSessionFactory
        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "book");
    }

    @Test
    public void testProperties() {
        SqlSession sqlSession = MybatisUtils.openSession();
        int count = sqlSession.insert("fuck_you.insertCar");
        sqlSession.commit();
        sqlSession.close();
        System.out.println(count > 0 ? "插入成功！" : "插入失败");
    }
}
