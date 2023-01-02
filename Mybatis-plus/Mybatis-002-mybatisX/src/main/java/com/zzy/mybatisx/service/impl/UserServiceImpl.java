package com.zzy.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.mybatisx.pojo.User;
import com.zzy.mybatisx.service.UserService;
import com.zzy.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 24211
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2023-01-02 15:41:51
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




