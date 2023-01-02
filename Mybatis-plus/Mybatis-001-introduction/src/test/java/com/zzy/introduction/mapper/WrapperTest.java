package com.zzy.introduction.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zzy.introduction.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 名字中含有a并且年龄在20-30岁之间并且邮箱不为空
        queryWrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testOrder() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 按年龄降序，按id升序查询
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testConditionPriority() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 查询用户名含有a并且（年龄大于20或邮箱为null）的用户
        queryWrapper.like("name", "a")
                .and(i->i.gt("age", 20).or().isNull("email"));
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 查询所有记录，但只查看 name 和 age 字段
        queryWrapper.select("name", "age");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testUpdateWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        // 修改用户名含有a并且（年龄大于20或邮箱为null）的用户，将用户名修改为 张三
        updateWrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"))
                .set("name", "张三");
        int count = userMapper.update(null, updateWrapper);
        System.out.println("修改的记录数为：" + count);
    }

    @Test
    public void testCondition() {
        // 浏览器传来的数据
        String contain = "";
        Integer ageLow = 20;
        Integer ageHigh = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(contain), "name", contain)
                .ge(ageLow!=null, "age", ageLow)
                .le(ageHigh!=null, "age", ageHigh);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testLambdaQueryWrapper() {
        // 浏览器传来的数据
        String contain = "";
        Integer ageLow = 20;
        Integer ageHigh = 30;

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(contain), User::getName, contain)
                .ge(ageLow != null, User::getAge, ageLow)
                .le(ageHigh != null, User::getAge, ageHigh);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(System.out::println);
    }
}
