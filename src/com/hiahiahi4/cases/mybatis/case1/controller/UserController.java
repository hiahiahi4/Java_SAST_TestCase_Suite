package com.hiahiahi4.cases.mybatis.case1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case1")
public class UserController {
	@Autowired
	private com.hiahiahi4.cases.mybatis.case1.mapper.UserMapper userMapper;
	
	@RequestMapping("/testMybatis")
	public void testMybatis(String name) {
		userMapper.getUser(name);
	}
}
