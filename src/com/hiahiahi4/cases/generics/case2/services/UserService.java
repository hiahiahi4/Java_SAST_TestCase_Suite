package com.hiahiahi4.cases.generics.case2.services;

import java.io.IOException;

public class UserService extends BaseService {
	/*
	 * java类继承特性：子类重写父类方法时，通过super去调用父类的同名方法
	 */
	public void run(String cmd) {
		super.execute(cmd);
	}
	public void execute(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd);   // safe
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
