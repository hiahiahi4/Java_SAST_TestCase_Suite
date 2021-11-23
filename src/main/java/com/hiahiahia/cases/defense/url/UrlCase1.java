package com.hiahiahia.cases.defense.url;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@RestController
public class UrlCase1 {
    @RequestMapping("/url/case1")
    public void safeurl(@RequestParam(value="url") String url) throws IOException {
        /*
         *  防护方法：用户输入是否等于某个url
         */
        if (url.matches("http://ifconfig.pro")) {
            URL u = new URL(url);
            URLConnection urlConnection = u.openConnection();  // safe
            urlConnection.connect();
        }
    }

    @RequestMapping("/url/case1_unsafe")
    public void unsafeurl(@RequestParam(value="url") String url) throws IOException {
        URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();  // unsafe
        urlConnection.connect();
    }
}
