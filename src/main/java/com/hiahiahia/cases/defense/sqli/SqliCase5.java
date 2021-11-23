package com.hiahiahia.cases.defense.sqli;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

@RestController
public class SqliCase5 {
    @RequestMapping("/sqli/case5")
    public void safeSql(@RequestParam(value="id") String id) throws Exception {
        /*
         *  防护方法：通过正则判断用户输入是否合法
         */
        if (StringUtils.isEmpty(id)) {
            throw new Exception("id is empty");
        } else if (!Pattern.matches("[a-zA-Z0-9]{3,20}", id)) {
            throw new Exception("id is invalid!");
        }
        String sql = String.format("select * from user where id='%s'", id);
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

    @RequestMapping("/sqli/case5_unsafe")
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
