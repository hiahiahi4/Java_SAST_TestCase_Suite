package com.hiahiahia.cases.defense.sqli;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class SqliCase1 {
    @RequestMapping("/sqli/case1")
    public void safeSql(@RequestParam(value="id") String id) {
        /*
         *  防护方法：将用户输入转换为int类型
         */
        int uid = Integer.parseInt(id);
        String sql = "select * from user where id = " + uid;
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

    @RequestMapping("/sqli/case1_unsafe")
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
