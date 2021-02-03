package com.hiahiahi4.cases.reflect;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case3")
public class case3 {
	@RequestMapping("/reflect")
	public void my_reflect(String cmd) throws IOException {
		Class cls;
		try {
			/*
			 * java反射支持
			 */
			cls = Class.forName("com.hiahiahi4.cases.reflect.service.caseService");
			Method m = cls.getDeclaredMethod("runCommand1", String.class, int.class);  
	        m.invoke(cls.newInstance(),cmd);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
	}
}

