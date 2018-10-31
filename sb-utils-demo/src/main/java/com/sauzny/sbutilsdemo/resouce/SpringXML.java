package com.sauzny.sbutilsdemo.resouce;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

@Component
public class SpringXML {

	public void demo() throws SAXException, IOException, ParserConfigurationException {
		
		// 如果是固定xml的话，可以使用@XmlRootElement解析
		
		// 对于不固定的xml解析，使用
		Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("phones.xml");
		Element element = dom.getDocumentElement();
		DomUtils.getChildElementByTagName(element, "TagName");
		
	}
}
