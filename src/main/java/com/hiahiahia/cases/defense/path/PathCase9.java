package com.hiahiahia.cases.defense.path;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class PathCase9 {
    @RequestMapping("/path/case9")
    public void safe_upload(@RequestParam(value="file") MultipartFile file) {
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

    @RequestMapping("/path/case9_unsafe")
    public void unsafe_upload(@RequestParam(value="file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File targetFile = new File("/store/upload" + File.separator + fileName);
        try {
            InputStream in = file.getInputStream();
            FileUtils.copyInputStreamToFile(in, targetFile);		// unsafe
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
