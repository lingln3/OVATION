package com.weixin.test;

import com.weixin.util.AccessToken;
import com.weixin.util.WeixinUtil;

import net.sf.json.JSONObject;


public class WeixinTest {
	public static void main(String[] args) {
		System.out.println("dd");
		try {
			AccessToken token = WeixinUtil.getAccessToken();
			System.out.println("获取token:"+token.getToken());
			System.out.println("获取expiresin:"+token.getExpiresIn());
			
			String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			//String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			int result = WeixinUtil.createMenu(token.getToken(), menu);
			if(result == 0) {
				System.out.println("成功创建菜单！");
			}else {
				System.out.println("错误码error_code:"+result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
