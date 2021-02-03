package com.hiahiahi4.cases.mybatis.case2.mapper;

import org.apache.ibatis.annotations.Update;

import com.hiahiahi4.cases.mybatis.case2.model.User;

public interface UserMapper {
	/*
	 * mybatis @Update注解支持
	 */
	@Update("UPDATE user SET name=${name} WHERE id =#{id}")    // unsafe
	User updateUser(User user);
}
