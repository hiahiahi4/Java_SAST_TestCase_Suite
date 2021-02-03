package com.hiahiahi4.cases.defense.pathtravel;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case4")
public class case4 {
	@RequestMapping("/safe_delete")
	public void safe_delete(String name) {
		/*
		 *  防护方法：判断用户输入的文件后缀名是否合法，不合法的话直接return
		 */
		int pos = name.lastIndexOf(".");
		String ext = name.substring(pos);
		if(".png" != ext || ".jpg" != ext) {
			return;
		}
        new File(name).delete();		// safe 
    }
}
