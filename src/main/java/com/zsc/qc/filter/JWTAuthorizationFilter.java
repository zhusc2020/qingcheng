package com.zsc.qc.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsc.qc.constant.SystemEnum;
import com.zsc.qc.security.JwtTokenUtils;
import com.zsc.qc.utils.CustomizeException;
import com.zsc.qc.utils.ResponseUtil;
import com.zsc.qc.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ClassName JWTAuthorizationFilter
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/6 16:55
 * @Version 1.0
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        // 如果请求头中没有Authorization信息则直接放行
        String url = request.getServletPath();
        String urlsb ="";
        if(StringUtils.isNotBlank(url)){
            urlsb = url.substring(1,4);
        }
        if ((tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) && "api".equals(urlsb)) {
            try {
                ResponseUtil.write(response,new Result(SystemEnum.SYS_LOGIN_ERROR.getCode(),SystemEnum.SYS_LOGIN_ERROR.getMsg()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        super.doFilterInternal(request, response, chain);
    }

    // 这里从token中获取用户信息并新建一个token
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        String username = JwtTokenUtils.getUsername(token);
        if (username != null){
            return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
        }
        return null;
    }
}

