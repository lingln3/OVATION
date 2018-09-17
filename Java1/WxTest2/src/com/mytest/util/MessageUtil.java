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
 * 消息的格式转换，xml转为map集合
 * @author snpas
 *
 */
public class MessageUtil {
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();//从request中获取输入流
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		for(Element e:list)//遍历list对象，将结果保存到集合中
		{
			map.put(e.getName(), e.getText());
		}
		ins.close();//关闭流
		return map;//返回map集合
	}
	
	/**
	 * 将文本消息对象转为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
	}
}
