package com.zsc.qc.utils;


import lombok.Data;
import java.util.UUID;

/**
 * @ClassName Result
 * @Description 统一返回值实体类
 * @Author zhusc
 * @Date 2020/1/3 16:23
 * @Version 1.0
 */
@Data
public class Result<T>{
    
    //返回值唯一ID
    private String resultId = UUID.randomUUID().toString().replace("-", "");
    // 接口调用状态码
    private Integer code;
    // 需要传递的信息，例如错误信息
    private String msg="";
    // 需要传递的数据
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public Result(Integer code ,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code ,String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }




}