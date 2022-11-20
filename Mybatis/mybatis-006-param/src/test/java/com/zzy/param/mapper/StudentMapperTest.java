package com.zzy.param.mapper;

import com.zzy.param.pojo.Student;
import com.zzy.param.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentMapperTest {
    @Test
    public void testQueryByAge() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryByAge(24);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testQueryByBirth() throws ParseException {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Date birth = new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-11");

        List<Student> students = mapper.queryByBirth(birth);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testQueryByNameAndAge() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.queryByNameAndAge("田所浩二", 24);
        System.out.println(student);
    }

    @Test
    public void testQueryByNameAndAge2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.queryByNameAndAge("田所浩二", 24);
        System.out.println(student);
    }

    @Test
    public void testQueryAll() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.queryAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testCountAll() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Integer integer = mapper.countAll();
        System.out.println("总记录条数为：" + integer);
    }
}
