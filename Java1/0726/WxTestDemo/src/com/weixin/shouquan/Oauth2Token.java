package com.weixin.shouquan;
/**
 * ��ҳ��Ȩ��Ϣ
 * @author snpas
 *
 */
public class Oauth2Token {
	private String accessToken;//��ҳ��Ȩ�ӿڵ���ƾ֤
	private int expiresIn;//ƾ֤��Чʱ��
	private String refreshToken;//����ˢ��ƾ֤
	private String openId;//�û���ʶ
	private String scope;//�û���Ȩ������
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
