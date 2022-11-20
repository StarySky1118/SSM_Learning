package com.zzy.advanced.mapper;

import com.zzy.advanced.pojo.Student;
import com.zzy.advanced.pojo.TeachingRelationship;
import com.zzy.advanced.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class StudentMapperTest {
    @Test
    public void testQueryStudentBySid() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.queryStudentBySid(1);
        System.out.println(student.getSname() + "所在班级名称为：" + student.getClazz().getCname());
    }

    @Test
    public void testQueryStudentBySidAssociation() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.queryStudentBySid(1);
        System.out.println(student.getSname() + "所在班级名称为：" + student.getClazz().getCname());
    }

    @Test
    public void testQueryStudentBySidAssociationByStep() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.queryStudentBySidAssociationByStep(1);
        System.out.println("该学生姓名为：" + student.getSname());

        System.out.println(student.getSname() + "所在班级名称为：" + student.getClazz().getCname());
    }

    @Test
    public void testQueryStudentsByCid() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.queryStudentsByCid(2);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testQueryStudentInfoBySid() {
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.queryStudentInfoBySid(1);
        List<TeachingRelationship> teachingRelationships = student.getTeachingRelationships();
        for (TeachingRelationship teachingRelationship : teachingRelationships) {
            System.out.println(teachingRelationship);
        }
    }

    @Test
    public void testEhCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);

        List<Student> students = mapper1.queryStudentsByCid(1);
        sqlSession1.close();

        List<Student> students1 = mapper2.queryStudentsByCid(1);
    }
}
