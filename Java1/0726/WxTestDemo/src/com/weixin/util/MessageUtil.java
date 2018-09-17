package com.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.weixin.message.TextMessage;

public class MessageUtil {
	/**
	 * xml杞负map闆嗗悎
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();//鑾峰彇杈撳叆娴?
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		for(Element e:list)//閬嶅巻
		{
			map.put(e.getName(), e.getText());
		}
		ins.close();//鍏抽棴娴?
		return map;
	}
	
	/**
	 * 杞负xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
	}
	
	/**
	 * 对URL地址进行EnCode处理
	 * @param url
	 * @return
	 */
	public static String urlEnCode(String url){
		String enCodeUrl = "";
		try {
			enCodeUrl = URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("转码失败！");
		}
		return enCodeUrl;
	}
}
