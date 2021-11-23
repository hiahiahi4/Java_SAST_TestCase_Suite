package com.hiahiahia.cases.defense.xxe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class XxeCase2 {
    @RequestMapping("/xxe/case2")
    public void safexxe(@RequestParam(value="xml") String xml) throws SAXException, ParserConfigurationException, IOException {
        /*
         *  防护方法：xxe SAXParser防护
         */
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        saxParserFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(is, new DefaultHandler());    // safe
    }

    @RequestMapping("/xxe/case2_unsafe")
    public void unsafexxe(@RequestParam(value="xml") String xml) throws IOException, ParserConfigurationException, SAXException {
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(is, new DefaultHandler());    // unsafe
    }
}
