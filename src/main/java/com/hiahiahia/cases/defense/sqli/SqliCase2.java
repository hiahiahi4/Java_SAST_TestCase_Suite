package com.hiahiahia.cases.defense.sqli;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class SqliCase2 {
    @RequestMapping("/sqli/case2")
    public void safeSql(@RequestParam(value="id") Integer id) {
        /*
         *  防护方法：用户输入int类型
         */
        String sql = "select * from user where id = " + id;
        Connection con;
        try {
            con = DriverManager.getConnection("", "sunny","");
            Statement stmt = con.createStatement();
            stmt.executeQuery(sql);   // safe
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/sqli/case2_unsafe")
    public void unsafeSql(@RequestParam(value="id") String id) {
        String sql = "select * from user where id = " + id;
        Connection con;
        try {
            con = DriverManager.getConnection("", "sunny","");
            Statement stmt = con.createStatement();
            stmt.executeQuery(sql);   // unsafe
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
