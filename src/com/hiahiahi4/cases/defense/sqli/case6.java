package com.hiahiahi4.cases.defense.sqli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case6")
public class case6 {
	@RequestMapping("/safeSql")
	public void safeSql(String name) throws Exception {
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
}
