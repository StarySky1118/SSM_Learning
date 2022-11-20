package com.zzy.advanced.mapper;

import com.zzy.advanced.pojo.TeachingRelationship;

import java.util.List;

public interface TeachingRelationshipMapper {
    /**
     * 使用 sid 查询教授关系集合
     * @param sid
     * @return
     */
    List<TeachingRelationship> queryTeachingRelationshipsBySid(Integer sid);
}
