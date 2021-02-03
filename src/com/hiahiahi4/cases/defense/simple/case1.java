package com.hiahiahi4.cases.defense.simple;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case1")
public class case1 {
	@RequestMapping("/safeRunCmd")
	public void safe_run_cmd(String cmd) throws IOException {
		/*
		 * 防护方法：用户输入是否等于某个安全字符串，是的话执行下一步操作
		 */
		if("safecmd1" == cmd) {
			Runtime.getRuntime().exec(cmd);		// safe 
		}
	}
}
