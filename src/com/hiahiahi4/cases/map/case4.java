package com.hiahiahi4.cases.map;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case4")
public class case4 {
	
	@RequestMapping("/map")
	public void testmap(String value) {
		/*
		 * Map支持, values方法
		 */
		Map<String, String> map = new HashMap<>();
		map.put("value", value);
		map.put("name", "name");
		for (String v : map.values()) {
			new File(v).delete();     // unsafe
        }
	}
}
