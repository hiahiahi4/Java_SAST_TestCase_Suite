package com.hiahiahia.cases.map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/case5")
public class case5 {
	
	@RequestMapping("/map")
	public void testmap(Map<String, String> map) {
		/*
		 * Map支持, entrySet方法
		 */
		for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
				Runtime.getRuntime().exec(entry.getValue());     // unsafe
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
