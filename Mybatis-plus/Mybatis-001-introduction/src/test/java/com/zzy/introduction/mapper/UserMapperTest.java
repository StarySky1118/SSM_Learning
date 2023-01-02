package com.zzy.introduction.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.introduction.enums.SexEnum;
import com.zzy.introduction.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        //selectList()根据MP内置的条件构造器查询一个list集合，null表示没有条件，即查询所有
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("Nance");
        user.setAge(25);
        user.setEmail("test6@baomidou.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testDeleteById() {
        int count = userMapper.deleteById(1607705014293975041L);
        System.out.println("受影响的行数为：" + count);
    }

    @Test
    public void testDeleteBatchIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(1608362040745488385L);
        ids.add(1608362095749558274L);
        int count = userMapper.deleteBatchIds(ids);
        System.out.println("受影响的行数为：" + count);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Nance");
        int count = userMapper.deleteByMap(map);
        System.out.println("受影响的行数为：" + count);
    }

    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(1607914460379025410L);
        user.setName("Nance");
        user.setAge(24);

        int count = userMapper.updateById(user);
        System.out.println("受影响的行数为：" + count);
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1607914460379025410L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        List<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);
        List<User> users = userMapper.selectBatchIds(idList);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectList1() {
        //查询所有用户信息
        //SELECT id,name,age,email FROM user
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testPagePlugin() {
        //设置分页参数
        Page<User> page = new Page<>(1, 2);
        userMapper.selectPage(page, null);
        //获取当前页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    @Test
    public void testPageDiy() {
        //设置分页参数
        Page<User> page = new Page<>(1, 2);
        userMapper.selectPageDiy(page, 20);
        //获取当前页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    @Test
    public void testEnum() {
        User user = new User();
        user.setName("Nance");
        user.setAge(25);
        user.setEmail("test6@baomidou.com");
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
}
