package com.zzy.advanced.service;

import com.zzy.advanced.pojo.Teacher;

import java.util.List;

public interface StudentService {
    /**
     * 根据学生编号查询教师列表
     * @param sid
     * @return
     */
    List<Teacher> queryTeachersBySid(Integer sid);
}
