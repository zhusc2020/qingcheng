package com.zsc.qc.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsc.qc.constant.SystemEnum;
import com.zsc.qc.utils.ResponseUtil;
import com.zsc.qc.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName JWTAuthenticationEntryPoint
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/8 16:13
 * @Version 1.0
 */
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        try {
            ResponseUtil.write(response,new Result(SystemEnum.SYS_AUTHORITY_ERROR.getCode(),SystemEnum.SYS_AUTHORITY_ERROR.getMsg()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

