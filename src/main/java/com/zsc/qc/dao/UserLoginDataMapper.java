package com.zsc.qc.dao;

import com.zsc.qc.entity.UserLoginData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLoginData record);

    int insertSelective(UserLoginData record);

    UserLoginData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLoginData record);

    int updateByPrimaryKey(UserLoginData record);

    //根据用户ID获取用户登录信息
    List<UserLoginData> getUserLoginDataListByUserId(Integer userId);






}