package com.zsc.qc.controller;

import com.zsc.qc.entity.User;
import com.zsc.qc.service.UserService;
import com.zsc.qc.utils.CustomizeException;
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
        System.out.print("");
        return userService.getUser();
    }

    @GetMapping("/getUserD")
    public List<User> getUserD(){
        throw new CustomizeException(1,"'11111");
    }
}
