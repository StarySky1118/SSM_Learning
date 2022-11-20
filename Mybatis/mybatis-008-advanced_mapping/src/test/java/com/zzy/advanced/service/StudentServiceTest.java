package com.zzy.advanced.service;

import com.zzy.advanced.pojo.Teacher;
import com.zzy.advanced.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentServiceTest {
    @Test
    public void testQueryTeachersBySid() {
        StudentService studentService = new StudentServiceImpl();
        for (Teacher teacher : studentService.queryTeachersBySid(1)) {
            System.out.println(teacher);
        }

    }
}
