package com.weixin.shouquan;

import java.util.List;

/**
 * ͨ����ҳ��Ȩ��ȡ���û���Ϣ
 * @author snpas
 *
 */

public class SNSUserInfo{
//�û���ʶ
	private String nickname;//�û��ǳ�
	private int sex;//�Ա�1�����У�2����Ů��0����δ֪
	private String country;//����
	private String province;//ʡ��
	private String city;//����
	private String headImgUrl;//�û�ͷ��ͼƬ����
	private List<String> privilegeList;
	//�û���Ȩ��Ϣ
	private String unionid;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public List<String> getPrivilegeList() {
		return privilegeList;
	}
	public void setPrivilegeList(List<String> privilegeList) {
		this.privilegeList = privilegeList;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
}
