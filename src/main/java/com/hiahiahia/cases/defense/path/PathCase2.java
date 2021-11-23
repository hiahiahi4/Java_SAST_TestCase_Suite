package com.hiahiahia.cases.defense.path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class PathCase2 {
    @RequestMapping("/path/case2")
    public void safe_delete(@RequestParam(value="path") String path) {
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

    @RequestMapping("/path/case2_unsafe")
    public void unsafe_delete(@RequestParam(value="path") String path) {
        File f = new File(path);
        f.delete();     // unsafe
    }
}
