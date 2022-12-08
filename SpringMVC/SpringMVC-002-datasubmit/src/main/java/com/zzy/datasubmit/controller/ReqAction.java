package com.zzy.datasubmit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 纳入 Spring 容器管理
public class ReqAction {
    @RequestMapping(value = "/req.action", method = RequestMethod.GET) // 请求路径映射
    public String reqDoGet() {
        return "get";
    }

    @RequestMapping(value = "req.action", method = RequestMethod.POST)
    public String reqDoPost() {
        return "post";
    }
}
