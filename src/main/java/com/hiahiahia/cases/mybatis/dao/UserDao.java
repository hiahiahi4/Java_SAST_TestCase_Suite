package com.hiahiahia.cases.mybatis.dao;

import com.hiahiahia.cases.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> selectUser(@Param(value="name")String name);
    void insertUser(User user);
}
