package com.hiahiahi4.cases.defense.simple;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case6")
public class case6 {
	@RequestMapping("/safeRunCmd")
	public void safe_run_cmd(String cmd1, String cmd2) throws IOException {
		/*
		 *  防护方法：对抗样本，两个不同的用户输入不互相影响
		 */
		if("safecmd1" == cmd1) {
			Runtime.getRuntime().exec(cmd2);   // safe 
		}
	}
}