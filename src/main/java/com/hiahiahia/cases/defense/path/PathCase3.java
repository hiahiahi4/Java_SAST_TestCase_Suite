package com.hiahiahia.cases.defense.path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class PathCase3 {
    @RequestMapping("/path/case3")
    public void safe_delete(@RequestParam(value="path") String path) {
        /*
         *  防护方法：对于用户输入的文件名，只取后缀部分拼接进路径中，无法跨目录
         */
        int pos = path.lastIndexOf(".");
        String ext = path.substring(pos);
        String fileName = "uuid" + ext;
        new File(fileName).delete();		// safe
    }

    @RequestMapping("/path/case3_unsafe")
    public void unsafe_delete(@RequestParam(value="path") String path) {
        String fileName = "uuid" + path;
        new File(fileName).delete();		// unsafe
    }
}
