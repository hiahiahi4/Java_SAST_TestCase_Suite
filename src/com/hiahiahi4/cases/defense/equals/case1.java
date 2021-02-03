package com.hiahiahi4.cases.defense.equals;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case1")
public class case1{

	@RequestMapping("/safeRunCmd")
	public void safe_run_cmd(String cmd) throws IOException {
		/*
		 *  防护方法：用户输入如果不等于某些字符串，则return
		 */
		if(!("safecmd1".equals(cmd) || "safecmd2".equals(cmd) || "safecmd3".equals(cmd))) {
			return;
		}
		Runtime.getRuntime().exec(cmd);		// safe 
	}

}