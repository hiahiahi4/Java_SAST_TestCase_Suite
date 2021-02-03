package com.hiahiahi4.cases.defense.url;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case2")
public class case2 {
	@RequestMapping("/safeurl")
	public void safeurl(String name) throws IOException {
		/*
		 *  防护方法：用户输入拼接进url的部分，无法改变一级域名
		 */
		String url = MessageFormat.format("http://www.safedomain.com/getUser?name={0}", name);
		URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();  //safe
        urlConnection.connect();       
    }
}
