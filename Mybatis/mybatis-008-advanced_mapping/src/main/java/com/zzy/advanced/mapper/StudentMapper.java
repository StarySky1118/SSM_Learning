package com.zzy.advanced.mapper;

import com.zzy.advanced.pojo.Student;
import com.zzy.advanced.pojo.TeachingRelationship;

import java.util.List;

public interface StudentMapper {

    /**
     * 根据 sid 查询学生信息及其关联的班级信息
     * @param sid 学号
     * @return 学生对象，内含班级对象引用
     */
    Student queryStudentBySid(Integer sid);

    /**
     *
     * @param sid
     * @return
     */
    Student queryStudentBySidAssociation(Integer sid);

    /**
     * 根据学号分步查询学生信息
     * @param sid
     * @return
     */
    Student queryStudentBySidAssociationByStep(Integer sid);

    /**
     * 根据班级编号查询学生列表
     * @param cid
     * @return
     */
    List<Student> queryStudentsByCid(Integer cid);

    Student queryStudentInfoBySid(Integer sid);
}
