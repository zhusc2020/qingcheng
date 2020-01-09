package com.zsc.qc.controller;

import com.zsc.qc.constant.SystemEnum;
import com.zsc.qc.entity.User;
import com.zsc.qc.service.UserService;
import com.zsc.qc.utils.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AuthController
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/6 17:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));// 把密码加密
            User save = userService.insertUser(user);
            return save;
    }




}

