package com.hiahiahi4.cases.defense.sqli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case3")
public class case3 {
	
	@RequestMapping("/safeSql")
	public void safeSql(String id) {
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
}