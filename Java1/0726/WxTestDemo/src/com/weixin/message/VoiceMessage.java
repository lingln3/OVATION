package com.weixin.message;
/**
 * ������Ϣ
 * @author snpas
 *
 */
public class VoiceMessage extends BaseMessage {
	private String MediaId;//������Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private String Format;//������ʽ����amr��speex��
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	
}
