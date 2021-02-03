package com.hiahiahi4.cases.generics.case2.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hiahiahi4.cases.generics.case2.services.UserService;

@RestController
@RequestMapping("/case1")
public class UserController {
	UserService us = new UserService();
	@RequestMapping("/generics")
	public void testgenerics(String cmd) throws IOException {
		us.run(cmd);
	}
}
