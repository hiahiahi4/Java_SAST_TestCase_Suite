package com.hiahiahia.cases.defense.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SimpleCase5 {
    @RequestMapping("/simple/case5")
    public void safe_run_cmd(@RequestParam(value="cmd") String cmd) throws IOException {
        String safe_cmd = "";
        /*
         *  防护方法：用户输入是否等于某个安全字符串，是的话进行一次安全的污染传递
         */
        if("safecmd1" == cmd) {
            safe_cmd = cmd;
        }
        Runtime.getRuntime().exec(cmd);		// unsafe
        Runtime.getRuntime().exec(safe_cmd);  	// safe
    }
}
