package com.hiahiahi4.cases.lombok;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hiahiahi4.cases.lombok.model.User1;

@RestController
@RequestMapping("/case2")
public class case2 {
	User1 user = new User1();
	@RequestMapping("/lombok")
	public void testlombok(String name) throws IOException {
		/*
		 * lombok @getter @setter注解支持
		 */
		user.setName(name);
		run(user);
	}
	
	public void run(User1 user) {
		String cmd = user.getName();
		Runtime.getRuntime().exec(cmd);		// unsafe
	}
}