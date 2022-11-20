package com.zzy.advanced.mapper;

import com.zzy.advanced.pojo.Clazz;
import com.zzy.advanced.pojo.Student;
import com.zzy.advanced.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ClazzMapperTest {
    @Test
    public void testInsertClazz() {
        SqlSession sqlSession = MybatisUtils.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);

        Clazz clazz = new Clazz(5, "高二二班");
        int count = mapper.insertClazz(clazz);
        sqlSession.commit();
        System.out.println(count > 0 ? "插入成功！" : "插入失败！");
    }

    @Test
    public void testQueryClazzByCid() {
        SqlSession sqlSession = MybatisUtils.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);

        Clazz clazz = mapper.queryClazzByCid(1);
        System.out.println(clazz);
    }

    @Test
    public void testQueryClazzByCidStep() {
        SqlSession sqlSession = MybatisUtils.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);

        Clazz clazz = mapper.queryClazzByCidStep(1);
        for (Student student : clazz.getStudents()) {
            System.out.println(student);
        }
    }
}
