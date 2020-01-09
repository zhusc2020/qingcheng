package com.zsc.qc.service.impl;

import com.zsc.qc.constant.SystemEnum;
import com.zsc.qc.dao.RoleMapper;
import com.zsc.qc.dao.UserDataMapper;
import com.zsc.qc.dao.UserLoginDataMapper;
import com.zsc.qc.dao.UserMapper;
import com.zsc.qc.entity.User;
import com.zsc.qc.entity.UserData;
import com.zsc.qc.service.UserService;
import com.zsc.qc.utils.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserLoginDataMapper userLoginDataMapper;

    /**
     * 获取用户列表
     * @return
     */
    public List<User> getUser(){
        return userMapper.getUser();
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Transactional
    public User insertUser(User user){
        try {
            if(checkUserName(user.getUserName())){
                throw  new CustomizeException(SystemEnum.CHECK_USER_NAME_EXIST.getCode(),SystemEnum.CHECK_USER_NAME_EXIST.getMsg());
            }
            UserData userData = user.getUserData();
            userMapper.insertUser(user);
            userData.setUserId(user.getId());
            userData.setCreateTime(new Date());
            userData.setModifyTime(new Date());
            userDataMapper.insert(userData);
            return user;
        } catch (Exception e) {
            throw new CustomizeException(SystemEnum.SYS_STATUS_INTERNAL_ERROR.getCode(),e.toString());
        }
    }

    /**
     * 根据用户名获取用户基本及角色信息
     * @param userName
     * @return
     */
    public User getUserByName(String userName){
        User user = userMapper.getUserByName(userName);
        if (user == null || user.getId() == null){
            throw new CustomizeException(SystemEnum.CHECK_USER_NAME_NULL.getCode(),SystemEnum.CHECK_USER_NAME_NULL.getMsg());
        }
        user.setRoleList(roleMapper.getRoleListByUserId(user.getId()));
        return user;
    }

    /**
     * 根据用户ID获取用户详细信息
     * @param userId
     * @return
     */
    public User getUserById(Integer userId){
        User user = userMapper.getUserById(userId);
        user.setUserData(userDataMapper.getUserDataByUserId(user.getId()));
        user.setRoleList(roleMapper.getRoleListByUserId(user.getId()));
        user.setUserLoginData(userLoginDataMapper.getUserLoginDataListByUserId(user.getId()));
        return user;
    }

    /**
     * 校验用户名是否存在
     * @param userName
     * @return
     */
    public Boolean checkUserName(String userName){
        User user = userMapper.getUserByName(userName);
        if (user == null){
            return false;
        }
        return true;
    }







}
