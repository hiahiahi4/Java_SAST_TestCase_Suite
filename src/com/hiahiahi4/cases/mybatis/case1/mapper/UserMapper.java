package com.hiahiahi4.cases.mybatis.case1.mapper;

import org.apache.ibatis.annotations.Select;

import com.hiahiahi4.cases.mybatis.case1.model.User;

public interface UserMapper {
	/*
	 * mybatis @Select注解支持
	 */
	@Select("SELECT * FROM user WHERE name = '${name}'")      //  unsafe
	User getUser(String name);
}
