package com.zzy.ajax.controller;

import com.zzy.ajax.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @RequestMapping("list.action")
    @ResponseBody // 专门处理 ajax 请求
    public List<Student> showStu() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("田所浩二", 24));
        students.add(new Student("德川", 22));
        return students; // 返回值为 Object，自动封装为 json
    }
}
