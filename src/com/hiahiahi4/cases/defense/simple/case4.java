package com.hiahiahi4.cases.defense.simple;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case4")
public class case4 {
	@RequestMapping("/safeRunCmd")
	public void safe_run_cmd(String cmd) throws IOException {
		/*
		 *  防护方法：用户输入是否等于某个安全字符串，不是的话将其赋值为该安全字符串
		 */
		if(!("safecmd1" == cmd)) {
			cmd = "safecmd1";
		}
		Runtime.getRuntime().exec(cmd);		// safe 
	}
}
