package com.zsc.qc.tests;

import com.zsc.qc.base.QingchengApplicationTest;
import org.junit.Test;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/16 10:54
 * @Version 1.0
 */


public class TestController extends QingchengApplicationTest {


    /**
     * 拼接固定位数字符串
     * @param
     * @return
     */
    @Test
    public void  test(){
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
    }


    /**
     * 字符串截取
     */
    @Test
    public void  test2(){
        String str = "12345678";
        String st = str.substring(1,2);
        System.out.println("st = "+st);
    }





















}
