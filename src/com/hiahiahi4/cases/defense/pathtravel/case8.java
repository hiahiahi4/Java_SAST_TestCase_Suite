package com.hiahiahi4.cases.defense.pathtravel;

import java.io.File;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case8")
public class case8 {
	@RequestMapping("/safe_delete")
	public void safe_delete(String name) {
		
		String path = getLocalPath(name);
		new File(path).delete();		// safe 
    }
    protected String getLocalPath(String filePath) {
    	/*
		 *  防护方法：取用户输入文件名或者路径最后一个/后面的部分，无法跨目录
		 */
    	String tmpDir = "/tmp";
        return tmpDir + filePath.substring(filePath.lastIndexOf("/"));
    }
}