package com.zzy.advanced.pojo;

import java.util.List;

/**
 * 学生 pojo 类
 */
public class Student {
    private Integer sid; // 学号
    private String sname; // 姓名
    private Clazz clazz; // 所属班级
    private List<TeachingRelationship> teachingRelationships; // 一个学生对应多个教授关系


    // 构造器
    public Student() {
    }

    public Student(Integer sid, String sname, Clazz clazz) {
        this.sid = sid;
        this.sname = sname;
        this.clazz = clazz;
    }

    // getter and setter
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public List<TeachingRelationship> getTeachingRelationships() {
        return teachingRelationships;
    }

    public void setTeachingRelationships(List<TeachingRelationship> teachingRelationships) {
        this.teachingRelationships = teachingRelationships;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
