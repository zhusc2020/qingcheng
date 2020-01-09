package com.zsc.qc.service;

import com.zsc.qc.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUser();

    User insertUser(User user);

    User getUserByName(String userName);

    User getUserById(Integer userId);

    Boolean checkUserName(String userName);




}
