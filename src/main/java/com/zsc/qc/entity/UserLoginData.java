package com.zsc.qc.entity;

import java.util.Date;

public class UserLoginData {
    private Integer id;

    private Integer userId;

    private Date loginTime;

    private String loginRegion;

    private String loginIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginRegion() {
        return loginRegion;
    }

    public void setLoginRegion(String loginRegion) {
        this.loginRegion = loginRegion == null ? null : loginRegion.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    @Override
    public String toString() {
        return "UserLoginData{" +
                "id=" + id +
                ", userId=" + userId +
                ", loginTime=" + loginTime +
                ", loginRegion='" + loginRegion + '\'' +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }
}