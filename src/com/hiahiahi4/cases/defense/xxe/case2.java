package com.hiahiahi4.cases.defense.xxe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.jdom.JDOMException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@RestController
@RequestMapping("/case2")
public class case2 {
	@RequestMapping("/safexxe")
	public void safexxe(String xml) throws JDOMException, IOException, ParserConfigurationException, SAXException {
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
}