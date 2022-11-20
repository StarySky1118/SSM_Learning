package com.zzy.advanced.mapper;

import com.zzy.advanced.pojo.Teacher;
import com.zzy.advanced.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TeacherMapperTest {
    @Test
    public void testQueryTeachersByTids() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        List<Integer> tids = new ArrayList<>();
        tids.add(1);
        tids.add(2);
        List<Teacher> teachers = mapper.queryTeachersByTids(tids);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}
