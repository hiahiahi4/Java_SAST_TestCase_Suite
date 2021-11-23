package com.hiahiahia.cases.defense.path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class PathCase8 {
    @RequestMapping("/path/case8")
    public void safe_delete(@RequestParam(value="name") String name) {
        String path = getLocalPath(name);
        new File(path).delete();		// safe
    }
    protected String getLocalPath(String filePath) {
        /*
         *  防护方法：取用户输入文件名或者路径最后一个/后面的部分，无法跨目录
         */
        String tmpDir = "/tmp";
        return tmpDir + filePath.substring(filePath.lastIndexOf("/"));
    }

    @RequestMapping("/path/case8_unsafe")
    public void unsafe_delete(@RequestParam(value="name") String name) {
        String path = "/tmp/" + name;
        new File(path).delete();		// unsafe
    }
}
