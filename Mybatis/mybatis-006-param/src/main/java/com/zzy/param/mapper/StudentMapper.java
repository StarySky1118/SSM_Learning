package com.zzy.param.mapper;

import com.zzy.param.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentMapper {

    Student queryByNameAndAge2(@Param("name") String name, @Param("age") Integer age);

    /**
     * 根据姓名和年龄查询
     *
     * @param name 姓名
     * @param age  年龄
     * @return 学生对象
     */
    Student queryByNameAndAge(String name, Integer age);

    /**
     * 根据年龄查询
     *
     * @param age 年龄
     * @return 学生列表
     */
    List<Student> queryByAge(Integer age);

    /**
     * 根据生日查询
     *
     * @param birth 生日
     * @return 学生列表
     */
    List<Student> queryByBirth(Date birth);

    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> queryAll();

    /**
     * 查询总记录条数
     * @return
     */
    Integer countAll();
}
