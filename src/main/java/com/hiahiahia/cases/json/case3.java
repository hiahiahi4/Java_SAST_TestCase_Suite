package com.hiahiahia.cases.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/case3")
public class case3 {
	
	@RequestMapping("/json")
	public void testjson(String json) throws IOException {
		/*
		 * json反序列化语法：将json字符串反序列化为JSONObject类
		 */
		JSONObject input = JSON.parseObject(json);
        for(Object path : input.values()) {
            new File((String) path).delete();   // unsafe
        }
	}
}
