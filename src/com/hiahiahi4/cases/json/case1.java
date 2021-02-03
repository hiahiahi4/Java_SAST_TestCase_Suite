package com.hiahiahi4.cases.json;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.hiahiahi4.cases.json.model.User;

@RestController
@RequestMapping("/case1")
public class case1 {
	
	@RequestMapping("/json")
	public void testjson(String json) throws IOException {
		/*
		 * json反序列化语法：将json字符串反序列化为model类
		 */
		User user = JSON.parseObject(json, User.class);
		getUserByName(user);
	}
	
	public void getUserByName(User user) {
		Connection con;
		try {
			con = DriverManager.getConnection("", "sunny","");
			Statement stmt = con.createStatement();
			stmt.executeQuery("SELECT * from user where name='" + user.getName() + "'");   // unsafe
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}