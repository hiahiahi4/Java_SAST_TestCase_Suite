package com.hiahiahi4.cases.overLoad;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case4")
public class case4 {
	@RequestMapping("/testOverload")
	public void testOverload(String name) {
		String cmds[] = {"/bin/sh", "-c", name};
		execute(cmds, "");
	}
	
	public void execute(String[] cmd, String str) {
		System.out.println(str);    
	}
	/*
	 * java方法重载，两个参数，类型不同
	 */
	public void execute(Object cmd, String str) throws IOException {
		Runtime.getRuntime().exec((String)cmd);     // safe
	}

}
