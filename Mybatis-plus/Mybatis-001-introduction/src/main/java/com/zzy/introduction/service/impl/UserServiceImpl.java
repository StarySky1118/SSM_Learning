package com.zzy.introduction.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.introduction.mapper.UserMapper;
import com.zzy.introduction.pojo.User;
import com.zzy.introduction.service.UserService;
import org.springframework.stereotype.Service;

@DS("master") // 指定操作 master 数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
