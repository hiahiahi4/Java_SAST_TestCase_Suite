package com.hiahiahia.cases.map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/case1")
public class case1 {
	
	@RequestMapping("/map")
	public void testmap(String value) {
		/*
		 * Map支持, 区分key和value
		 */
		Map<String, String> map = new HashMap<>();
		map.put("value", value);
		new File(map.get("value")).delete();   // unsafe
	}
}