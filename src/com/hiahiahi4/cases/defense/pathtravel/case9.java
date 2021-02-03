package com.hiahiahi4.cases.defense.pathtravel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/case9")
public class case9 {
	@RequestMapping("/safe_upload")
	public void safe_upload(MultipartFile file) {
		uploadFile(file);
    }
	
	public void uploadFile(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		/*
		 *  防护方法：判断用户输入文件名是否以某个安全后缀名结尾
		 */
		if(fileName.endsWith(".jpg")) {
			File targetFile = new File("/store/upload" + File.separator + fileName);
			try {
				InputStream in = file.getInputStream();
				FileUtils.copyInputStreamToFile(in, targetFile);		// safe
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}