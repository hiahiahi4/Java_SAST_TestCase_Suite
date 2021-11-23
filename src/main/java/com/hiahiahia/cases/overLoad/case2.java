package com.hiahiahia.cases.overLoad;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/case2")
public class case2 {
	@RequestMapping("/testOverload")
	public void testOverload(String name) {
		try {
			execute(name, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void execute(String cmd) {
		System.out.println(cmd);
	}
	/*
	 * java方法重载，参数个数不同
	 */
	public void execute(String cmd, boolean isLinux) throws IOException {
		String cmds[] = null;
		if(isLinux) {
			cmds = new String[]{"/bin/sh", "-c", cmd};
		} else {
			cmds = new String[]{"cmd.exe", "/c", cmd};
			
		}
		Runtime.getRuntime().exec(cmds);     // unsafe
	}

}