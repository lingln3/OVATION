package com.weixin.message;
/**
 * ��Ƶ��Ϣ
 * @author snpas
 *
 */
public class VedioMessage extends BaseMessage {
	private String MediaId;//��Ƶ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private String ThumbMediaId;//��Ƶ��Ϣ����ͼ��ý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
	
}
