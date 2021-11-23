package com.hiahiahia.cases.overLoad;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/case3")
public class case3 {
	@RequestMapping("/testOverload")
	public void testOverload(String name) {
		try {
			execute(name, "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void execute(String[] cmd, String str) {
		System.out.println(str);
	}
	/*
	 * java方法重载，两个参数，类型不同
	 */
	public void execute(Object cmd, String str) throws IOException {
		Runtime.getRuntime().exec((String)cmd);     // unsafe
	}

}