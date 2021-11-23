package com.hiahiahia.cases.lombok;

import com.hiahiahia.cases.lombok.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
	
	public void run(User user) throws IOException {
		String cmd = user.getName();
		Runtime.getRuntime().exec(cmd);		// unsafe
	}
}