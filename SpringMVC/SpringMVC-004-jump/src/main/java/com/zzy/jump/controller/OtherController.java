package com.zzy.jump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherController {
    @RequestMapping("/other.action")
    public String jump() {
        return "main";
    }
}
