package com.zsc.qc.service.impl;

import com.zsc.qc.constant.SystemEnum;
import com.zsc.qc.entity.Role;
import com.zsc.qc.entity.User;
import com.zsc.qc.security.JwtUser;
import com.zsc.qc.service.UserService;
import com.zsc.qc.utils.CustomizeException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDetailsServiceImpl
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/6 16:41
 * @Version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByName(s);
        logger.info("loadUserByUsername: " + user);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if(null == user ){
          throw new CustomizeException(SystemEnum.CHECK_USER_NAME_NULL.getCode(),SystemEnum.CHECK_USER_NAME_NULL.getMsg());
        }
        for (Role role:user.getRoleList()){
            authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
        }
        user.setGrantedAuthorities(authorities); //用于登录时 @AuthenticationPrincipal 标签取值
        return new JwtUser(user);
    }

}

