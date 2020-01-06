package com.zsc.qc.dao;

import com.zsc.qc.entity.UserLoginData;

public interface UserLoginDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLoginData record);

    int insertSelective(UserLoginData record);

    UserLoginData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLoginData record);

    int updateByPrimaryKey(UserLoginData record);
}