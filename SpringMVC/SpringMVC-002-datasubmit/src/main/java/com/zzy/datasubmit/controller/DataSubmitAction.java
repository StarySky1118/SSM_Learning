package com.zzy.datasubmit.controller;

import com.zzy.datasubmit.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataSubmitAction {
    @RequestMapping("/one.action")
    public String one(@RequestParam("name") String name, @RequestParam("age") int age) {
        System.out.println(name + "事" + age + "岁");
        return "success";
    }

    @RequestMapping("/two.action")
    public String two(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/three/{name}/{age}.action")
    public String three(@PathVariable("name") String name, @PathVariable("age") int age) {
        System.out.println(name + "事" + age + "岁");
        return "success";
    }
}
