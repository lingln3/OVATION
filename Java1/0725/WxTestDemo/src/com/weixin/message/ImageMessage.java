package com.weixin.message;
/**
 * ͼƬ��Ϣ
 * @author snpas
 *
 */
public class ImageMessage extends BaseMessage {
	private String PicUrl;//ͼƬ���ӣ���ϵͳ���ɣ�
	private String MediaId;//ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
	
}
