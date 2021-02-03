package com.hiahiahi4.cases.generics.case1.services;

import java.io.IOException;

public abstract class BaseService {
	public void execute(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd);     // unsafe
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
