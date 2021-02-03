package com.hiahiahi4.cases.defense.sqli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case2")
public class case2 {
	
	@RequestMapping("/safeSql")
	public void safeSql(Integer id) {
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
}
