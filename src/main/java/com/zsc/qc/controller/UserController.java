package com.zsc.qc.controller;

import com.zsc.qc.entity.User;
import com.zsc.qc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<User> getUser(){
        return userService.getUser();
    }

    @GetMapping("/getUserByName")
    public User getUserByName(String userName){
        return userService.getUserByName(userName);
    }

    @GetMapping("/getUserById")
    public User getUserById(Integer userId){
        return userService.getUserById(userId);
    }



    @GetMapping("/checkUserName")
    public Boolean checkUserName(String userName){
        return userService.checkUserName(userName);
    }




















}
