package com.hiahiahi4.cases.defense.simple;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case3")
public class case3 {
	@RequestMapping("/safeRunCmd")
	public void safe_run_cmd(String cmd) throws IOException {
		/*
		 *  防护方法：用户输入是否等于某个安全字符串，不是的话抛出异常
		 */
		if(!("safecmd1" == cmd)) {
			throw new IOException();
		}
		Runtime.getRuntime().exec(cmd);		// safe 
	}
}