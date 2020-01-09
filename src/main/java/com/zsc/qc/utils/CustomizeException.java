package com.zsc.qc.utils;

import com.zsc.qc.constant.SystemEnum;

/**
 * @ClassName CustomizeException
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/6 14:18
 * @Version 1.0
 */
public class CustomizeException extends RuntimeException{

    private int statusCode = SystemEnum.SYS_STATUS_INTERNAL_ERROR.getCode();

    public CustomizeException(int statusCode,String message) {
        super(message);
        this.statusCode = statusCode;
    }
    public CustomizeException(String message) {
        super(message);
    }

    public int getStatusCode() {
        return statusCode;
    }
}

