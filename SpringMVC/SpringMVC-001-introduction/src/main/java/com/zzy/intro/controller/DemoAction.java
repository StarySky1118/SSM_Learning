package com.zzy.intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 纳入 Spring 容器管理
@RequestMapping("/user")
public class DemoAction {
    /**
     * 方法规范：
     *  修饰符必须为 public，其他可以随意
     */
    @RequestMapping("/demo.action") // 方法的访问路径
    public String demo() {
        return "main";
    }
}
