package com.hiahiahia.cases.defense.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SimpleCase1 {
    @RequestMapping("/simple/case1")
    public void safe_run_cmd(@RequestParam(value="cmd") String cmd) throws IOException {
        /*
         * 防护方法：用户输入是否等于某个安全字符串，是的话执行下一步操作
         */
        if("safecmd1" == cmd) {
            Runtime.getRuntime().exec(cmd);		// safe
        }
    }

    @RequestMapping("/simple/case1_unsafe")
    public void unsafe_run_cmd(@RequestParam(value="cmd") String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);		// unsafe

    }
}
