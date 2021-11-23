package com.hiahiahia.cases.defense.xxe;

import org.jdom2.input.SAXBuilder;
import org.jdom2.JDOMException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class XxeCase1 {
    @RequestMapping("/xxe/case")
    public void safexxe(@RequestParam(value="xml") String xml) throws JDOMException, IOException {
        /*
         *  防护方法：xxe SAXBuilder防护
         */
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        SAXBuilder saxBuilder = new SAXBuilder();
        saxBuilder.setFeature("http://xml.org/sax/features/external-general-entities", false);
        saxBuilder.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        saxBuilder.build(is);    // safe
    }

    @RequestMapping("/xxe/case_unsafe")
    public void unsafexxe(@RequestParam(value="xml") String xml) throws JDOMException, IOException {
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        SAXBuilder saxBuilder = new SAXBuilder();
        saxBuilder.build(is);    // unsafe
    }
}
