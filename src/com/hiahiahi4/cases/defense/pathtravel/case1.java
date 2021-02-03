package com.hiahiahi4.cases.defense.pathtravel;

import java.io.File;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case1")
public class case1{

	@RequestMapping("/safe_delete")
	public void safe_delete(String path) throws IOException{
		String safe_path = safe_path(path);
	    File f = new File(safe_path);
	    f.delete();		// safe 
	}
	public String safe_path(String filePath) {
		/*
		 *  防护方法：对用户输入的文件名或者路径名进行过滤，如果存在./,则返回空
		 */
        if(!filePath.startsWith("/media/file/") || filePath.contains("./")) {
        	return "";
        } else {
        	return filePath;
        }
    }

}