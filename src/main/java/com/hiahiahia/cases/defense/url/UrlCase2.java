package com.hiahiahia.cases.defense.url;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;

@RestController
public class UrlCase2 {
    @RequestMapping("/url/case2")
    public void safeurl(@RequestParam(value="url") String name) throws IOException {
        /*
         *  防护方法：用户输入拼接进url的部分，无法改变一级域名
         */
        String url = MessageFormat.format("http://www.safedomain.com/getUser?name={0}", name);
        URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();  // safe
        urlConnection.connect();
    }

    @RequestMapping("/url/case2_unsafe")
    public void unsafeurl(@RequestParam(value="url") String url) throws IOException {
        URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();  // unsafe
        urlConnection.connect();
    }
}
