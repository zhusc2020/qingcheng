package com.zsc.qc.security;

import com.zsc.qc.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @ClassName JwtUser
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/6 16:49
 * @Version 1.0
 */
public class JwtUser implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    // 写一个能直接使用user创建jwtUser的构造器
    public JwtUser(User user) {
        id = user.getId();
        username = user.getUserName();
        password = user.getPassword();
        authorities = user.getAuthorities();
    }




    // 获取权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    // 账号是否未过期，默认是false，记得要改一下
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账号是否未锁定，默认是false，记得也要改一下
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 账号凭证是否未过期，默认是false，记得还要改一下
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 这个有点抽象不会翻译，默认也是false，记得改一下
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 打印下信息看
    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}


