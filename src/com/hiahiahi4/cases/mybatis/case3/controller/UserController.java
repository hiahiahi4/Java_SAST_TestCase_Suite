package com.hiahiahi4.cases.mybatis.case3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiahiahi4.cases.mybatis.case3.model.User;

@RestController
@RequestMapping("/case3")
public class UserController {
	@Autowired
	private com.hiahiahi4.cases.mybatis.case3.mapper.UserMapper userMapper;
	
	@RequestMapping("/testMybatis")
	public void testMybatis(User user) {
		userMapper.insertUser(user);
	}
}
