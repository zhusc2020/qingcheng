package com.zsc.qc.utils;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName ResponseUtil
 * @Description 将后台处理完的结果写回前端页面, 如jsp页面;或者可用于在ajax异步调用后台方法,该方法处
 *              理完相应业务逻辑之后将结果返回,这个结果即通过这个工具类实现
 * @Author zhusc
 * @Date 2020/1/9 13:54
 * @Version 1.0
 */
public class ResponseUtil {

    public static void write(HttpServletResponse response, Object o)throws Exception{
        try {
            String jsonString = JSONObject.toJSONString(o, SerializerFeature.WriteMapNullValue);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(jsonString);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
