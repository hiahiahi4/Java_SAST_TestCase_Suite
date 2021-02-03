package com.hiahiahi4.cases.json;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hiahiahi4.cases.json.model.User;

public class case7 {
	@RequestMapping("/json")
	public void testjson(String json) throws IOException {
		/*
		 * json反序列化语法：将json字符串反序列化为model类(jackson)
		 */
		ObjectMapper om = new ObjectMapper();
		User user = om.readValue(json, User.class);
        getUser(user);
	}
	
	public void getUser(User user) {
		Connection con;
		try {
			con = DriverManager.getConnection("", "sunny","");
			Statement stmt = con.createStatement();
			stmt.executeQuery("SELECT * from user where name='" + user.getName() + "' and age=" + user.getAge());   // unsafe
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
