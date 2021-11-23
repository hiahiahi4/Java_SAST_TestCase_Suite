package com.hiahiahia.cases.defense.equals;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EqualCase1 {
    @RequestMapping("/equals/case1")
    public void safe_run_cmd(@RequestParam(value="cmd") String cmd) throws IOException {
        /*
         *  防护方法：用户输入如果不等于某些字符串，则return
         */
        if(!("safecmd1".equals(cmd) || "safecmd2".equals(cmd) || "safecmd3".equals(cmd))) {
            return;
        }
        Runtime.getRuntime().exec(cmd);		// safe
    }

    @RequestMapping("/equals/case1_unsafe")
    public void unsafe_run_cmd(@RequestParam(value="cmd") String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);		// unsafe
    }
}
