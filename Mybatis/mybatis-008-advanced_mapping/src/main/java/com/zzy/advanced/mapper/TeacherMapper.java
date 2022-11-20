package com.zzy.advanced.mapper;

import com.zzy.advanced.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    /**
     * 使用教师编号数组批量查询教师
     * @param tids
     * @return
     */
    List<Teacher> queryTeachersByTids(@Param("tids") List<Integer> tids);
}
