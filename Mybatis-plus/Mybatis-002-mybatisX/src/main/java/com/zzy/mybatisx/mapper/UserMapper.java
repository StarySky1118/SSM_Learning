package com.zzy.mybatisx.mapper;
import org.apache.ibatis.annotations.Param;

import com.zzy.mybatisx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author 24211
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-01-02 15:41:51
* @Entity com.zzy.mybatisx.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {
   int insertSelective(User user);
}




