package com.zsc.qc.dao;

import com.zsc.qc.entity.UserData;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserData record);

    UserData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserData record);

    int updateByPrimaryKey(UserData record);

    //根据用户ID获取用户详细信息
    UserData getUserDataByUserId(Integer userId);



}