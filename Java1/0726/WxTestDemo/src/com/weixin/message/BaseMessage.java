package com.weixin.message;
/**
 * ������Ϣ�ĸ���
 * @author snpas
 *
 */
public class BaseMessage {
	private String ToUserName;//������΢�ź�
	private String FromUserName;//���ͷ��ʺţ�һ��OpenID��
	private long CreateTime;//��Ϣ����ʱ�� �����ͣ�
	private String MsgType;//��Ϣ������
	private String MsgId;//��Ϣid��64λ����
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
	
}
