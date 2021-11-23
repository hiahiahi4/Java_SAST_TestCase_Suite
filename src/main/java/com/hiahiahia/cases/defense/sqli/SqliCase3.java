package com.hiahiahia.cases.defense.sqli;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class SqliCase3 {
    @RequestMapping("/sqli/case3")
    public void safeSql(@RequestParam(value="id") String id) {
        String sql = String.format("select * from user where id='%s'", filterSqlInject(id));
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

    public String filterSqlInject(String str) {
        /*
         * 防护方法：参数中包含'; # --等符号，替换为空
         */
        String regex = ".*([';#]+|(--)+).*";
        return str.replaceAll(regex, " ");
    }

    @RequestMapping("/sqli/case3_unsafe")
    public void unsafeSql(@RequestParam(value="id") String id) {
        String sql = String.format("select * from user where id='%s'", id);
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
