package com.woniuxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String root(Model model){
        model.addAttribute("msg","我是后端写入的消息");
        return "index";
    }


}
