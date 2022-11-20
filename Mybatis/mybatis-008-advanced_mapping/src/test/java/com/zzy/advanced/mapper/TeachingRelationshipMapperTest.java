package com.zzy.advanced.mapper;

import com.zzy.advanced.pojo.TeachingRelationship;
import com.zzy.advanced.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeachingRelationshipMapperTest {

    @Test
    public void testQueryTeachingRelationshipsBySid() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeachingRelationshipMapper mapper = sqlSession.getMapper(TeachingRelationshipMapper.class);

        List<TeachingRelationship> teachingRelationships = mapper.queryTeachingRelationshipsBySid(1);
        for (TeachingRelationship teachingRelationship : teachingRelationships) {
            System.out.println(teachingRelationship);
        }
    }
}
