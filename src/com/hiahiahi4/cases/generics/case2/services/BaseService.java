package com.hiahiahi4.cases.generics.case2.services;

public abstract class BaseService {
	public void execute(String cmd) {
		System.out.println(cmd);    // safe
	}
}
