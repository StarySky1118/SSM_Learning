package com.zzy.advanced.service.impl;

import com.zzy.advanced.mapper.StudentMapper;
import com.zzy.advanced.mapper.TeacherMapper;
import com.zzy.advanced.pojo.Student;
import com.zzy.advanced.pojo.Teacher;
import com.zzy.advanced.pojo.TeachingRelationship;
import com.zzy.advanced.service.StudentService;
import com.zzy.advanced.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Teacher> queryTeachersBySid(Integer sid) {
        SqlSession sqlSession = MybatisUtils.openSession();

        // 查询关系列表
        Student student = sqlSession.getMapper(StudentMapper.class).queryStudentInfoBySid(sid);

        // 提取关系列表中的教师编号成为一个列表
        List<Integer> tids = new ArrayList<>();
        for (TeachingRelationship teachingRelationship : student.getTeachingRelationships()) {
            tids.add(teachingRelationship.getTid());
        }

        // 根据教师编号列表查询教师列表
        return sqlSession.getMapper(TeacherMapper.class).queryTeachersByTids(tids);
    }
}
