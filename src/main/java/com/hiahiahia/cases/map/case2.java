package com.hiahiahia.cases.map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/case2")
public class case2 {
	
	@RequestMapping("/map")
	public void testmap(String value) {
		/*
		 * Map支持, 区分不同key的value
		 */
		Map<String, String> map = new HashMap<>();
		map.put("value", value);
		map.put("name", "name");
		new File(map.get("name")).delete();     // safe
	}
}
