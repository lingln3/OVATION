package com.mytest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.mytest.util.CheckUtil;
import com.mytest.util.MessageUtil;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import sun.misc.MessageUtils;

public class WeixinServlet extends HttpServlet {

	/**
     * 校验签名
     * @param signature 微信加密签名.
     * @param timestamp 时间戳.
     * @param nonce 随机数.
     * @return
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		
		PrintWriter out = resp.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			Map<String,String> map =MessageUtil.xmlToMap(req);
			String fromUserName = map.get("FromUserName");
			//String createTime = map.get("CreateTime");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String toUserName = map.get("ToUserName");
			//String msgId = map.get("MsgId");
			String message = null;
			//判断是否为文本消息
			if("text".equals(msgType)){
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime());
				text.setContent("您发送的消息是："+content);
				message = MessageUtil.textMessageToXml(text);
				
				System.out.println(message);
			}
			out.println(message);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
				
	}
	
	
	
}
