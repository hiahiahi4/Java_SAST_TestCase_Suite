package com.hiahiahi4.cases.defense.pathtravel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/case7")
public class case7 {
	@RequestMapping("/safe_upload")
	public void safe_upload(MultipartFile file) {
		uploadFile(file);
    }
	
	public void uploadFile(MultipartFile file) {
		/*
		 *  防护方法：取用户输入文件名的hashcode+后缀
		 */
		String fileName = file.getOriginalFilename();
        String fileTyle = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        String name = fileName.hashCode() + fileTyle;
        File targetFile = new File("/store/upload" + File.separator + name);
        try {
        	InputStream in = file.getInputStream();
			FileUtils.copyInputStreamToFile(in, targetFile);		// safe
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
