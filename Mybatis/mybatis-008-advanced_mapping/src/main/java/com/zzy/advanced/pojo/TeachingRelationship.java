package com.zzy.advanced.pojo;

public class TeachingRelationship {
    private Integer id; // 自增主键
    private Integer sid; // 学生编号
    private Integer tid; // 教师编号

    public TeachingRelationship() {
    }

    public TeachingRelationship(Integer id, Integer sid, Integer tid) {
        this.id = id;
        this.sid = sid;
        this.tid = tid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "TeachingRelationship{" +
                "id=" + id +
                ", sid=" + sid +
                ", tid=" + tid +
                '}';
    }
}
