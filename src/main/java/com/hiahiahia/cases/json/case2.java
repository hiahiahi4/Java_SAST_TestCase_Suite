package com.hiahiahia.cases.json;

import com.hiahiahia.cases.json.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("/case2")
public class case2 {
	
	@RequestMapping("/json")
	public void testjson(String json) throws IOException {
		/*
		 * json反序列化语法：将json字符串反序列化为model类
		 * 对抗：model类int类型变量不会被污染
		 */

		User user = JSON.parseObject(json, User.class);
		getUserByAge(user);
	}
	
	public void getUserByAge(User user) {
		Connection con;
		try {
			con = DriverManager.getConnection("", "sunny","");
			Statement stmt = con.createStatement();
			stmt.executeQuery("SELECT * from user where age=" + user.getAge());   // safe
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}