package com.zzy.jump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 纳入 Spring 容器管理
public class JumpController {
    @RequestMapping("/one.action")
    public String jump1() {
        return "main";
    }

    @RequestMapping("/two.action")
    public String jump2() {
        return "forward:other.action";
    }

    @RequestMapping("/three.action")
    public String jump3() {
        return "redirect:/admin/main.jsp";
    }

    @RequestMapping("/four.action")
    public String jump4() {
        return "redirect:/other.action";
    }
}
