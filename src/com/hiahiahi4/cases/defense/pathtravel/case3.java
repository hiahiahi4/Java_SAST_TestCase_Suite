package com.hiahiahi4.cases.defense.pathtravel;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case3")
public class case3 {
	@RequestMapping("/safe_delete")
	public void safe_delete(String name) {
		/*
		 *  防护方法：对于用户输入的文件名，只取后缀部分拼接进路径中，无法跨目录
		 */
		int pos = name.lastIndexOf(".");
		String ext = name.substring(pos);
		String fileName = "uuid" + ext;
		new File(fileName).delete();		// safe 
    }
}
