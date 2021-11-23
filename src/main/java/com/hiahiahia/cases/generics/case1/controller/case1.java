package com.hiahiahia.cases.generics.case1.controller;

import com.hiahiahia.cases.generics.case1.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/case1")
public class case1 {
    UserService us = new UserService();
    @RequestMapping("/generics/case1")
    public void generics_case1(String cmd) throws IOException {
        us.run(cmd);
    }
}
