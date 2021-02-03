package com.hiahiahi4.cases.reflect.service;

import java.io.IOException;

public class caseService {
	public void runCommand(String cmd) throws IOException {
		java.lang.Runtime.getRuntime().exec(cmd);		// unsafe
	}
	
	public void runCommand(String cmd, int i) throws IOException {
		java.lang.Runtime.getRuntime().exec(cmd);		// unsafe
	}
	
	public void runCommand1(String cmd, int i) throws IOException {
		java.lang.Runtime.getRuntime().exec(cmd);		// unsafe
	}
}
