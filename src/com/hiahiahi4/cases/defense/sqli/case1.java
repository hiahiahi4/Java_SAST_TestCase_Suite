package com.hiahiahi4.cases.defense.sqli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case1")
public class case1 {
	
	@RequestMapping("/safeSql")
	public void safeSql(String id) {
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
}