package com.mytest.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mytest.servlet.TextMessage;
import com.thoughtworks.xstream.XStream;

/**
 * ��Ϣ�ĸ�ʽת����xmlתΪmap����
 * @author snpas
 *
 */
public class MessageUtil {
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();//��request�л�ȡ������
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		for(Element e:list)//����list���󣬽�������浽������
		{
			map.put(e.getName(), e.getText());
		}
		ins.close();//�ر���
		return map;//����map����
	}
	
	/**
	 * ���ı���Ϣ����תΪxml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
	}
}
