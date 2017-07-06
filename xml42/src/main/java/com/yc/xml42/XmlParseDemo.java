package com.yc.xml42;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParseDemo {

	public static void main(String[]args) throws Exception{
		//取xml文件中的内容
		//1.加载半结构化数据文件到程序中
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("person.xml");

		//2.解析文件流成文档对象Document
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.parse(in);

		//3.使用Document对象取出半结构化数据文件中的数据内容

		NodeList nodes=doc.getChildNodes();


		for (int i = 0; i < nodes.getLength(); i++) {
			Node node=nodes.item(i);
			if (node.getNodeType()==node.ELEMENT_NODE) {
				nodes=node.getChildNodes();
				for (int j = 0; j < nodes.getLength(); j++) {
					if (nodes.item(j).getNodeType()==node.ELEMENT_NODE) {
						System.out.println(nodes.item(j).getNodeName() + ":" + nodes.item(j).getTextContent());
						//	System.out.println(ele.getFirstChild().getNodeValue());
					} 
				}
			}
		}


	}
}
