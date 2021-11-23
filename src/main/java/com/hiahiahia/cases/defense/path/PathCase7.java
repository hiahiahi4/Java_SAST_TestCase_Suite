package com.hiahiahia.cases.defense.path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class PathCase7 {
    @RequestMapping("/path/case7")
    public void safe_upload(@RequestParam(value="file") MultipartFile file) {
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

    @RequestMapping("/path/case7_unsafe")
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
