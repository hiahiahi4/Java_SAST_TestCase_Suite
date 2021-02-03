package com.hiahiahi4.cases.lombok;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiahiahi4.cases.lombok.model.User;

@RestController
@RequestMapping("/case1")
public class case1 {
	User user = new User();
	@RequestMapping("/lombok")
	public void testlombok(String name) throws IOException {
		/*
		 * lombok @Data注解支持
		 */
		user.setName(name);
		run(user);
	}
	
	public void run(User user) {
		String cmd = user.getName();
		Runtime.getRuntime().exec(cmd);		// unsafe
	}
}