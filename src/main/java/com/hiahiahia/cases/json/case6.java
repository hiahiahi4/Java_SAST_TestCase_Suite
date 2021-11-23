package com.hiahiahia.cases.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/case6")
public class case6 {
	
	@RequestMapping("/json")
	public void testjson(String json) throws IOException {
		/*
		 * json反序列化语法：将json字符串反序列化为Map类(jackson)
		 */
		ObjectMapper om = new ObjectMapper();
		Map<String,Object> param = om.readValue(json, Map.class);
        String path = (String) param.get("path");
        new File(path).delete();   // unsafe
	}
}

