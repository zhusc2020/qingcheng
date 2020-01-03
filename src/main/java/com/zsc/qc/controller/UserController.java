package com.zsc.qc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/user")
public class UserController {



    @GetMapping("/getUser")
    public void getUser(){
        System.out.print("11111111122222222");
    }


}
