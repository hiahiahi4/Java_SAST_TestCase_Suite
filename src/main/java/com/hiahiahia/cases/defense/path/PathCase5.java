package com.hiahiahia.cases.defense.path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PathCase5 {
    @RequestMapping("/path/case5")
    public void safe_delete(@RequestParam(value="path") String name) {
        /*
         *  防护方法：判断用户输入的文件后缀名是否在白名单中，是的话执行下一步操作
         */
        int pos = name.lastIndexOf(".");
        String ext = name.substring(pos);
        List<String> whitelist = new ArrayList<String>();
        whitelist.add(".jpg");
        whitelist.add(".png");
        whitelist.add(".gif");
        if(whitelist.contains(ext)) {
            new File(name).delete();		// safe
        }
    }

    @RequestMapping("/path/case5_unsafe")
    public void unsafe_delete(@RequestParam(value="path") String name) {
        new File(name).delete();		// unsafe
    }
}
