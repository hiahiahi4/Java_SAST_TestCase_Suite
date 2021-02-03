package com.hiahiahi4.cases.defense.equals;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case2")
public class case2{
	@RequestMapping("/safeRunCmd")
	public void safe_run_cmd(String cmd) throws IOException {
		/*
		 *  防护方法：用户输入等于某些字符串，才执行下一步操作
		 */
		if(cmd.equals("safecmd1") || cmd.equals("safecmd2") || cmd.equals("safecmd3")) {
			Runtime.getRuntime().exec(cmd);		// safe 
		}	
	}
}

