package com.hiahiahia.cases.defense.path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;

@RestController
public class PathCase1 {
    @RequestMapping("/path/case1")
    public void safe_delete(@RequestParam(value="path") String path) {
        String safe_path = safe_path(path);
        File f = new File(safe_path);
        f.delete();      // safe
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
    @RequestMapping("/path/case1_unsafe")
    public void unsafe_delete(@RequestParam(value="path",required = false) String path) {
        File f = new File(path);
        f.delete();     // unsafe
    }
}
