package com.hiahiahia.cases.generics.case2.controller;

import com.hiahiahia.cases.generics.case2.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/case2")
public class case2 {
    UserService us = new UserService();
    @RequestMapping("/generics/case2")
    public void testgenerics(String cmd) throws IOException {
        us.run(cmd);
    }
}
