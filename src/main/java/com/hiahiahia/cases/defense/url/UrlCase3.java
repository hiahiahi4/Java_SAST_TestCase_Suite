package com.hiahiahia.cases.defense.url;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@RestController
public class UrlCase3 {
    @RequestMapping("/url/case3")
    public void safeurl(@RequestParam(value="url") String url) throws IOException {
        URL u = new URL(url);
        if(u.getHost().endsWith(".safeDomain.com")) {
            URLConnection urlConnection = u.openConnection();  // safe
            urlConnection.connect();
        }
    }

    @RequestMapping("/url/case3_unsafe1")
    public void safeurl1(@RequestParam(value="url") String url) throws IOException {
        if(url.startsWith("http://www.safeDomain.com")) {
            URL u = new URL(url);
            URLConnection urlConnection = u.openConnection();  // unsafe
            urlConnection.connect();
        }
    }

    @RequestMapping("/url/case3_unsafe2")
    public void unsafeurl2(@RequestParam(value="url") String url) throws IOException {
        URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();  // unsafe
        urlConnection.connect();
    }
}