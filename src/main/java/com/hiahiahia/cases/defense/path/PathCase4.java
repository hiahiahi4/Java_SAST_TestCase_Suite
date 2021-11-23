package com.hiahiahia.cases.defense.path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class PathCase4 {
    @RequestMapping("/path/case4")
    public void safe_delete(@RequestParam(value="path") String name) {
        /*
         *  防护方法：判断用户输入的文件后缀名是否合法，不合法的话直接return
         */
        int pos = name.lastIndexOf(".");
        String ext = name.substring(pos);
        if(".png" != ext || ".jpg" != ext) {
            return;
        }
        new File(name).delete();		// safe
    }

    @RequestMapping("/path/case4_unsafe")
    public void unsafe_delete(@RequestParam(value="path") String name) {
        new File(name).delete();		// unsafe
    }
}
