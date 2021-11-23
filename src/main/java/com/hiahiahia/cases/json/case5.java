package com.hiahiahia.cases.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/case5")
public class case5 {
	@RequestMapping("/json")
	public void testjson(String json) throws IOException {
		/*
		 * json反序列化语法：将json字符串反序列化为JSONObject类
		 */
		JSONObject input = JSON.parseObject(json);
		JSONArray array = input.getJSONArray("test");
        for(Object path : array.getJSONObject(0).values()) {
            new File((String) path).delete();   // unsafe
        }
	}
}

