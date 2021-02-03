package com.hiahiahi4.cases.defense.pathtravel;

import java.io.File;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case2")
public class case2{

	@RequestMapping("/safe_delete")
	public void safe_delete(String path) throws IOException{
		if(is_safe_path(path)) {
			File f = new File(path);
		    f.delete();		// safe 
		}
	}
	
	public boolean is_safe_path(String filePath) {
		/*
		 *  防护方法：对用户输入的文件名或者路径名进行安全性判断，如果存在../,则返回false
		 */
        if(filePath.contains("../")) {
            return false;
        } else {
            return true;
        }
    }

}