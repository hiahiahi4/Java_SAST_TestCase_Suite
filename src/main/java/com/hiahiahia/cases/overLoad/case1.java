package com.hiahiahia.cases.overLoad;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/case1")
public class case1 {
	@RequestMapping("/testOverload")
	public void testOverload(String name) {
		List<String> list = new ArrayList<String>();
		list.add(name);
		execute(list);
	}
	/*
	 * java方法重载，一个参数，类型不同
	 */
	public void execute(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd);    // safe
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void execute(List<String> list) {
		for(String i : list) {
			System.out.println(i);
		}
	}

}
