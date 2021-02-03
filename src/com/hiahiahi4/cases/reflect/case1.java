package com.hiahiahi4.cases.reflect;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiahiahi4.cases.reflect.service.caseService;

@RestController
@RequestMapping("/case1")
public class case1 {
	@RequestMapping("/reflect")
	public void my_reflect(String cmd) throws IOException {
		caseService c1s = new caseService();
		Class clazz = c1s.getClass();
		Method m1;
		try {
			/*
			 * java反射支持
			 */
			m1 = clazz.getDeclaredMethod("runCommand", String.class);      // 
			m1.invoke(c1s, cmd);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}