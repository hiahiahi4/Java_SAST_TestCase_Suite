package com.hiahiahi4.cases.defense.pathtravel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case5")
public class case5 {
	@RequestMapping("/safe_delete")
	public void safe_delete(String name) {
		/*
		 *  防护方法：判断用户输入的文件后缀名是否在白名单中，是的话执行下一步操作
		 */
		int pos = name.lastIndexOf(".");
		String ext = name.substring(pos);
		List<String> whitelist = new ArrayList<String>();
		whitelist.add(".jpg");
		whitelist.add(".png");
		whitelist.add(".gif");
		if(whitelist.contains(ext)) {
			new File(name).delete();		// safe
		}
	}
}
