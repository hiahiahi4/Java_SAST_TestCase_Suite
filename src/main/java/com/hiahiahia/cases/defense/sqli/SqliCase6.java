package com.hiahiahia.cases.defense.sqli;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class SqliCase6 {
    @RequestMapping("/sqli/case6")
    public void safeSql(@RequestParam(value="id") String name) throws Exception {
        /*
         *  防护方法：预编译
         */
        String sql = "insert into user value(?)";
        Connection con;
        try {
            con = DriverManager.getConnection("", "sunny","");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();    // safe
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/sqli/case6_unsafe")
    public void unsafeSql(@RequestParam(value="id") String id) {
        String sql = "insert into user value(" + id + ")";
        Connection con;
        try {
            con = DriverManager.getConnection("", "sunny","");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();    // unsafe
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
