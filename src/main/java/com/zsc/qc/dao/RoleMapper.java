package com.zsc.qc.dao;

import com.zsc.qc.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //根据用户ID获取角色列表
    List<Role> getRoleListByUserId(Integer userId);

}