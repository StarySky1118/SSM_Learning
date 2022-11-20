package com.zzy.advanced.mapper;

import com.zzy.advanced.pojo.Clazz;

public interface ClazzMapper {

    /**
     * 插入班级记录
     * @param clazz 班级对象
     * @return 插入的记录条数
     */
    int insertClazz(Clazz clazz);

    /**
     * 根据班级编号查询班级信息
     * @param cid
     * @return
     */
    Clazz queryClazzByCid(Integer cid);

    /**
     * 根据班级编号分步查询班级信息
     * @param cid
     * @return
     */
    Clazz queryClazzByCidStep(Integer cid);
}
