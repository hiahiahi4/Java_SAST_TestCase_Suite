package com.hiahiahi4.cases.defense.xxe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom.JDOMException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

@RestController
@RequestMapping("/case3")
public class case3 {
	@RequestMapping("/unsafexxe")
	public void unsafexxe(String xml) throws JDOMException, IOException, SAXException, DocumentException {
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
