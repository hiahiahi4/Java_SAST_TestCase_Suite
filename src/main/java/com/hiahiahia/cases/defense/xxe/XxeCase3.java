package com.hiahiahia.cases.defense.xxe;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RestController
public class XxeCase3 {
    @RequestMapping("/xxe/case3")
    public void safexxe(@RequestParam(value="xml") String xml) throws SAXException, DocumentException {
        /*
         *  防护方法：xxe SAXReader防护
         */
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        SAXReader saxReader = new SAXReader();
        saxReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
        saxReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        saxReader.setValidation(false);
        saxReader.read(is);     // safe
    }

    @RequestMapping("/xxe/case3_unsafe")
    public void unsafexxe(@RequestParam(value="xml") String xml) throws SAXException, DocumentException {
        /*
         *  防护方法：xxe 不完全防护
         */
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        SAXReader saxReader = new SAXReader();
        saxReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
        //saxReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        saxReader.setValidation(false);
        saxReader.read(is);     // unsafe
    }
}
