package com.zzy.jump.controller;

import com.zzy.jump.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class DataAction {
    @RequestMapping("/five.action")
    public String jump(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session,
                       Model model,
                       Map map,
                       ModelMap modelMap) {
        User user = new User("田所浩二", "114514");
        request.setAttribute("request", user);
        session.setAttribute("session", user);
        model.addAttribute("model", user);
        map.put("map", user);
        modelMap.addAttribute("modelMap", user);
        return "main"; // 默认使用请求转发方式
    }
}
