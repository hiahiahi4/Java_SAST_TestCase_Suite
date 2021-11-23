package com.hiahiahia.cases.map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/case3")
public class case3 {
	
	@RequestMapping("/map")
	public void testmap(String value) {
		/*
		 * Map支持, 区分key和value
		 */
		Map<String, String> map = new HashMap<>();
		map.put("value", value);
		map.put("name", "name");
		for (String entry : map.keySet()) {
			new File(entry).delete();     // safe
        }
	}
}
