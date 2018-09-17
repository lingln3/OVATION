package com.weixin.message;

/**
 * 文本消息
 * @author snpas
 *
 */

public class TextMessage extends BaseMessage{

	private String Content;
	
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

}
