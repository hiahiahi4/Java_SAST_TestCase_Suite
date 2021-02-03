package com.hiahiahi4.cases.defense.xxe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case1")
public class case1 {
	@RequestMapping("/safexxe")
	public void safexxe(String xml) throws JDOMException, IOException {
		/*
		 *  防护方法：xxe SAXBuilder防护
		 */
		InputStream is = new ByteArrayInputStream(xml.getBytes());
        SAXBuilder saxBuilder = new SAXBuilder();
        saxBuilder.setFeature("http://xml.org/sax/features/external-general-entities", false);
        saxBuilder.setFeature("http://xml.org/sax/features/external-parameter-entities", false); 
        saxBuilder.build(is);    // safe 
	}
}
