package com.zsc.qc.dao;

import com.zsc.qc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    //获取用户列表
    List<User> getUser();

    //添加用户
    int insertUser(User user);

    //根据用户名获取用户信息
    User getUserByName(String userName);

    //根据用户ID获取用户信息
    User getUserById(Integer userId);




}
