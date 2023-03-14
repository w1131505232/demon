package com.woniuxy.controller;

import com.woniuxy.entity.User;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/allUsers")
    public List<User> allUser(){
        List<User> userList = userService.list();
        return userList;
    }



}
