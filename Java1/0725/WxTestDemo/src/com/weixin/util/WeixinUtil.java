package com.weixin.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.UnsupportedCharsetException;

import javax.swing.text.html.parser.Entity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.weixin.menu.Button;
import com.weixin.menu.ClickButton;
import com.weixin.menu.Menu;
import com.weixin.menu.ViewButton;

import net.sf.json.JSONObject;


public class WeixinUtil {
	private static final String APPID="wxe9988d0e19c62021";
	private static final String APPSECRET="1da49152de2d63bb49e027a62686b91f";
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private static final String URL_WXTESTDEMO = "";//服务器地址
	/**
	 * get璇锋眰
	 * @param url
	 * @return
	 */
	public static JSONObject doGetStr(String url) {
		HttpClient httpClient = new DefaultHttpClient();
	   // HttpClient httpClient = HttpClientBuilder.create().build();
	    HttpGet httpGet = new HttpGet(url);
	    System.out.println(url);
	    JSONObject jsonObject = null;
	    try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if(entity != null) {
				String result = EntityUtils.toString(entity,"UTF-8");
				System.out.println(result);
				jsonObject = JSONObject.fromObject(result);
				System.out.println(jsonObject.toString());
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return jsonObject;
	}
	
	/**
	 * get璇锋眰2
	 */
	
	/**
	 * post璇锋眰
	 * @param url
	 * @param outStr
	 * @return
	 */
	public static JSONObject doPostStr(String url,String outStr) {
	    HttpClient httpClient = new DefaultHttpClient();
//		HttpClient httpClient = HttpClientBuilder.create().build();
	    
	    HttpPost httpPost = new HttpPost(url);
	    JSONObject jsonObject = null;
	    try {
	    	String encoded = URLEncoder.encode (url,"UTF-8");
	    	System.out.println("url:"+url);
	    	System.out.println("encoded:"+encoded);
//	    	HttpPost httpPost = new HttpPost(encoded);
			httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
			System.out.println("outstr:"+outStr);
			System.out.println("httppost:"+EntityUtils.toString(httpPost.getEntity(),"UTF-8"));
			HttpResponse response = httpClient.execute(httpPost);
			String result = EntityUtils.toString(response.getEntity(),"UTF-8");
			System.out.println("result:"+result);
			jsonObject = JSONObject.fromObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return jsonObject;
	}
	
	/**
	 * 初始化菜单
	 * 3个根菜：
	 * 知识测试：
	 * 微课堂：
	 * 微平台：身份绑定，我的党支部，我的积分，操作指南
	 */
	public static Menu initMenu() {
		Menu menu = new Menu();//建立菜单对象
		Button zhiShiTest_btn = new Button();//知识测试
		Button weiPingTai_btn = new Button();//微平台
		Button WeiKeTang_btn = new Button();//微课堂
		
		//微平台的子菜单
		weiPingTai_btn.setName("微平台");
		//身份绑定
		ViewButton id_btn = new ViewButton();//身份绑定
		id_btn.setName("身份绑定");
		id_btn.setType("view");
		id_btn.setUrl("http://www.baidu.com");
		//我的党支部
		ViewButton orgnization_btn = new ViewButton();//我的党支部
		orgnization_btn.setName("我的党支部");
		orgnization_btn.setType("view");
		orgnization_btn.setUrl("http://www.iqiyi.com/");
//		我的积分
		ViewButton grade_btn = new ViewButton();//我的积分
		grade_btn.setName("我的积分");
		grade_btn.setType("view");
		grade_btn.setUrl("http://kehax9.natappfree.cc/WxTestDemo/html/index2.html");
//		操作指南
		ViewButton operator_btn = new ViewButton();//操作指南
		operator_btn.setName("操作指南");
		operator_btn.setType("view");
		operator_btn.setUrl("http://kehax9.natappfree.cc/WxTestDemo/html/index2.html");
		//设置子菜单
		weiPingTai_btn.setSub_button(new Button[]{id_btn,orgnization_btn,grade_btn,operator_btn});
		
		ClickButton button11 = new ClickButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");
		
		ViewButton shouquan_btn = new ViewButton();//创建页面授权按钮
		shouquan_btn.setName("页面授权3");
		shouquan_btn.setType("view");
		shouquan_btn.setUrl(getAuthorUrl());
		
		zhiShiTest_btn.setName("知识测试");//知识测试
		zhiShiTest_btn.setSub_button(new Button[]{shouquan_btn});
		WeiKeTang_btn.setName("微课堂");//微课堂
		WeiKeTang_btn.setSub_button(new Button[]{button11});
		menu.setButton(new Button[]{zhiShiTest_btn,WeiKeTang_btn,weiPingTai_btn});
		return menu;
	}
	
	/**
	 * 初始化菜单2
	 * @return
	 */
	public static Menu initMenu2(){
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");
		ViewButton button21 = new ViewButton();
		button21.setName("view菜单");
		button21.setType("view");
		button21.setUrl("http://www.baidu.com");
		ClickButton button31 = new ClickButton();
		button31.setName("扫描二维码");
		button31.setType("scancode_push");
		button31.setKey("31");
		ClickButton button32 = new ClickButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");
		Button[] button = new Button[]{button31,button32};
		Button button2 = new Button();
		button2.setName("多级菜单");
		button2.setSub_button(button);//“多级菜单”中包含2个子菜单
		menu.setButton(new Button[]{button11,button21,button2});
		return menu;
	}
	/**
	 * 创建菜单
	 * @param token
	 * @param menu
	 * @return
	 */
	public static int createMenu(String token,String menu) {
		int result = 0;
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, menu);
		if(jsonObject != null) {
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
	/**
	 * 获取access_token
	 * @return
	 */
	public static AccessToken getAccessToken() { 
		AccessToken token = new AccessToken();
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		if(jsonObject != null)
		{
			token.setToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return token;
	}
	
	/**
	 * 获取微信网页授权页面链接
	 * @return
	 */
	private static String getAuthorUrl(){
		String url = MessageUtil.urlEnCode("http://8icean.natappfree.cc/WxTestDemom/wx.do");//回调页面转码
		String authorUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";//授权引导界面
		authorUrl = authorUrl.replace("APPID", APPID).replace("REDIRECT_URI", url).replace("SCOPE","snsapi_userinfo");
		return authorUrl;
	}
}
