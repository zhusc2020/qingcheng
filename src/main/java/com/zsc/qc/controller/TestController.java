package com.zsc.qc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/16 10:54
 * @Version 1.0
 */

@RestController
@RequestMapping("/auth")
public class TestController {


    /**
     * 拼接固定位数字符串
     * @param <T>
     * @return
     */
    @GetMapping("/test")
    public <T>String test(){
        String a = "1";
        String b = "1";
        String c = "1";
        String d = "1111111111111111";
        String e = "1";
        String f = String.format("%1$1s",a)+
                String.format("%1$1s",b)+
                String.format("%1$1s",c)+
                String.format("%1$17s",d)+
                String.format("%1$80s",e);
        System.out.println("fffffff = "+f.length());
        System.out.println("fffffff111 <"+f+">");
        return f;
    }



}
