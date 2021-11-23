package com.hiahiahia.cases.defense.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SimpleCase6 {
    @RequestMapping("/simple/case6")
    public void unsafe_run_cmd(@RequestParam(value="cmd1") String cmd1, @RequestParam(value="cmd2") String cmd2) throws IOException {
        /*
         *  防护方法：对抗样本，两个不同的用户输入不互相影响
         */
        if("safecmd1" == cmd1) {
            Runtime.getRuntime().exec(cmd2);   // unsafe
        }
    }
}
