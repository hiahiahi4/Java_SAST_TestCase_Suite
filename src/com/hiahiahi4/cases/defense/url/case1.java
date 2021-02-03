package com.hiahiahi4.cases.defense.url;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case1")
public class case1 {
	@RequestMapping("/safeurl")
	public void safeurl(String url) throws IOException {
		/*
		 *  防护方法：用户输入是否等于某个url
		 */
		if (url.matches("http://ifconfig.pro")) {
			URL u = new URL(url);
            URLConnection urlConnection = u.openConnection();  //safe
            urlConnection.connect();    
        }
    }
}

