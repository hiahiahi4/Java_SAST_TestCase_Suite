package com.hiahiahia.cases.defense.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SimpleCase3 {
    @RequestMapping("/simple/case3")
    public void safe_run_cmd(@RequestParam(value="cmd") String cmd) throws IOException {
        /*
         *  防护方法：用户输入是否等于某个安全字符串，不是的话抛出异常
         */
        if(!("safecmd1" == cmd)) {
            throw new IOException();
        }
        Runtime.getRuntime().exec(cmd);		// safe
    }

    @RequestMapping("/simple/case3_unsafe")
    public void unsafe_run_cmd(@RequestParam(value="cmd") String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);		// unsafe
    }
}
