package com.hiahiahi4.cases.defense.simple;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case5")
public class case5 {
	@RequestMapping("/safeRunCmd")
	public void safe_run_cmd(String cmd) throws IOException {
		String safe_cmd = "";
		/*
		 *  防护方法：用户输入是否等于某个安全字符串，是的话进行一次安全的污染传递
		 */
		if("safecmd1" == cmd) {
			safe_cmd = cmd;
		}
		Runtime.getRuntime().exec(cmd);		// unsafe 
		Runtime.getRuntime().exec(safe_cmd);  	// safe 
	}
}
