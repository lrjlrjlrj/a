package com.yc.xml42;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



public class XmlParseDemo02 {
	public static void main(String[]args) throws Exception{
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("person.xml");
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		parser.parse(in, new MyParserHandler());
	}
}
