package com.zsc.qc.dao;

import com.zsc.qc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    List<User> getUser();


}
