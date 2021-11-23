package com.hiahiahia.cases.defense.equals;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EqualCase2 {
    @RequestMapping("/equals/case2")
    public void safe_run_cmd(@RequestParam(value="cmd") String cmd) throws IOException {
        /*
         *  防护方法：用户输入等于某些字符串，才执行下一步操作
         */
        if(cmd.equals("safecmd1") || cmd.equals("safecmd2") || cmd.equals("safecmd3")) {
            Runtime.getRuntime().exec(cmd);		// safe
        }
    }
    @RequestMapping("/equals/case2_unsafe")
    public void unsafe_run_cmd(@RequestParam(value="cmd") String cmd) throws IOException {
        /*
         *  防护方法：用户输入等于某些字符串，才执行下一步操作
         */
        Runtime.getRuntime().exec(cmd);		// unsafe

    }
}
