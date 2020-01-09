package com.zsc.qc.entity;

/**
 * @ClassName LoginUser
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/9 14:36
 * @Version 1.0
 */
public class LoginUser {

    private String  userName;
    private String  password;
    private String  expiration;

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

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", expiration='" + expiration + '\'' +
                '}';
    }
}
