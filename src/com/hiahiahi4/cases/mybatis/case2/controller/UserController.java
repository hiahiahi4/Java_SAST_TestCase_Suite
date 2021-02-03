package com.hiahiahi4.cases.mybatis.case2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiahiahi4.cases.mybatis.case2.model.User;

@RestController
@RequestMapping("/case2")
public class UserController {
	@Autowired
	private com.hiahiahi4.cases.mybatis.case2.mapper.UserMapper userMapper;
	
	@RequestMapping("/testMybatis")
	public void testMybatis(String name) {
		userMapper.updateUser(new User(1, name));
	}
}
