package com.hiahiahia.cases.lombok;

import com.hiahiahia.cases.lombok.model.User1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
	
	public void run(User1 user) throws IOException {
		String cmd = user.getName();
		Runtime.getRuntime().exec(cmd);		// unsafe
	}
}