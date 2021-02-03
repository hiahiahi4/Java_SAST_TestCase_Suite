package com.hiahiahi4.cases.mybatis.case3.mapper;

import org.apache.ibatis.annotations.Insert;

import com.hiahiahi4.cases.mybatis.case3.model.User;

public interface UserMapper {
	/*
	 * mybatis @Insert注解支持  
	 */
	@Insert("INSERT INTO user(id, name) VALUES(#{id}, #{name}")    // safe
	User insertUser(User user);
}
