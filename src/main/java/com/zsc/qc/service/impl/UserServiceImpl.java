package com.zsc.qc.service.impl;

import com.zsc.qc.dao.UserDao;
import com.zsc.qc.entity.User;
import com.zsc.qc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;




    public List<User> getUser(){
        return userDao.getUser();
    }









}
