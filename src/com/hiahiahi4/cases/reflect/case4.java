package com.hiahiahi4.cases.reflect;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case4")
public class case4 {
	@RequestMapping("/reflect")
	public void my_reflect(String cmd) throws IOException {
		Class runtimeClass;
		try {
			/*
			 * java反射支持
			 */
			runtimeClass = Class.forName("java.lang.Runtime");
			Constructor constructor = runtimeClass.getDeclaredConstructor();
			constructor.setAccessible(true);
			Object runtimeInstance = constructor.newInstance();
			Method runtimeMethod = runtimeClass.getMethod("exec", String.class);
			Process process = (Process) runtimeMethod.invoke(runtimeInstance, cmd);		// unsafe
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
			}
		}
	}
