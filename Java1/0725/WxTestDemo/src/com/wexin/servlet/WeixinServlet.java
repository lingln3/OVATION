package com.wexin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.weixin.message.TextMessage;
import com.weixin.util.CheckUtil;
import com.weixin.util.MessageUtil;

public class WeixinServlet extends HttpServlet{

	/**
	 * get请求获取数据
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		System.out.println("signature:"+signature);
		System.out.println("timestamp:"+timestamp);
		System.out.println("nonce:"+nonce);
		System.out.println("echostr:"+echostr);
		PrintWriter out = resp.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");//设置编码的方式
		//resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();//获取客户端提交的数据
		try {
			Map<String,String> map =MessageUtil.xmlToMap(req);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			//String createTime = map.get("CreateTime");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			//String msgId = map.get("MsgId");
			String message = null;
			//锟叫讹拷锟角凤拷为锟侥憋拷锟斤拷息
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
