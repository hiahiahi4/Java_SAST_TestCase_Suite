package com.hiahiahia.cases.mybatis.controller;

import com.hiahiahia.cases.mybatis.dao.UserDao;
import com.hiahiahia.cases.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/mybatis")
public class mybatisCase1 {
    @Autowired
    private UserDao uDao;
    @RequestMapping("/case1")
    public List<User> getUser(@RequestParam(value="name") String name) {
        return uDao.selectUser(name);

    }
}
