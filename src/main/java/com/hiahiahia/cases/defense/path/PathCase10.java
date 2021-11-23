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
public class PathCase10 {
    @RequestMapping("/path/case10")
    public void safe_upload(@RequestParam(value="file") MultipartFile file) throws IOException {
        uploadFile(file);
    }
    public void uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        /*
         *  防护方法：File对象获取绝对路径，进行startwith判断
         */
        File tmpFile = new File(fileName);
        if(!tmpFile.getCanonicalPath().startsWith("/tmp/")) {
            throw new IOException();
        }
        try {
            InputStream in = file.getInputStream();
            FileUtils.copyInputStreamToFile(in, tmpFile);		// safe
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/path/case10_unsafe")
    public void unsafe_upload(@RequestParam(value="file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File targetFile = new File(fileName);
        try {
            InputStream in = file.getInputStream();
            FileUtils.copyInputStreamToFile(in, targetFile);		// unsafe
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
