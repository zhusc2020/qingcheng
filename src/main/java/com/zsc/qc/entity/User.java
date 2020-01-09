package com.zsc.qc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class User {


    private Integer id;
    private String  userName;

    //@JsonIgnore//此注解用于返回时忽略此字段
    private String  password;

    private String  mobile;
    private String  email;
    private String  remark;
    private Integer state;

    private UserData userData;

    private List<Role> roleList;

    private List<UserLoginData> UserLoginData;

    @JsonIgnore
    private List<? extends GrantedAuthority> authorities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<com.zsc.qc.entity.UserLoginData> getUserLoginData() {
        return UserLoginData;
    }

    public void setUserLoginData(List<com.zsc.qc.entity.UserLoginData> userLoginData) {
        UserLoginData = userLoginData;
    }

    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setGrantedAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                ", userData=" + userData +
                ", roleList=" + roleList +
                ", UserLoginData=" + UserLoginData +
                ", authorities=" + authorities +
                '}';
    }
}
