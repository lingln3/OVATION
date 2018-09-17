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
	private static final String URL_WXTESTDEMO = "";//��������ַ
	/**
	 * get请求
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
	 * get请求2
	 */
	
	/**
	 * post请求
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
	 * ��ʼ���˵�
	 * 3�����ˣ�
	 * ֪ʶ���ԣ�
	 * ΢���ã�
	 * ΢ƽ̨����ݰ󶨣��ҵĵ�֧�����ҵĻ��֣�����ָ��
	 */
	public static Menu initMenu() {
		Menu menu = new Menu();//�����˵�����
		Button zhiShiTest_btn = new Button();//֪ʶ����
		Button weiPingTai_btn = new Button();//΢ƽ̨
		Button WeiKeTang_btn = new Button();//΢����
		
		//΢ƽ̨���Ӳ˵�
		weiPingTai_btn.setName("΢ƽ̨");
		//��ݰ�
		ViewButton id_btn = new ViewButton();//��ݰ�
		id_btn.setName("��ݰ�");
		id_btn.setType("view");
		id_btn.setUrl("http://www.baidu.com");
		//�ҵĵ�֧��
		ViewButton orgnization_btn = new ViewButton();//�ҵĵ�֧��
		orgnization_btn.setName("�ҵĵ�֧��");
		orgnization_btn.setType("view");
		orgnization_btn.setUrl("http://www.iqiyi.com/");
//		�ҵĻ���
		ViewButton grade_btn = new ViewButton();//�ҵĻ���
		grade_btn.setName("�ҵĻ���");
		grade_btn.setType("view");
		grade_btn.setUrl("http://kehax9.natappfree.cc/WxTestDemo/html/index2.html");
//		����ָ��
		ViewButton operator_btn = new ViewButton();//����ָ��
		operator_btn.setName("����ָ��");
		operator_btn.setType("view");
		operator_btn.setUrl("http://kehax9.natappfree.cc/WxTestDemo/html/index2.html");
		//�����Ӳ˵�
		weiPingTai_btn.setSub_button(new Button[]{id_btn,orgnization_btn,grade_btn,operator_btn});
		
		ClickButton button11 = new ClickButton();
		button11.setName("click�˵�");
		button11.setType("click");
		button11.setKey("11");
		
		ViewButton shouquan_btn = new ViewButton();//����ҳ����Ȩ��ť
		shouquan_btn.setName("ҳ����Ȩ3");
		shouquan_btn.setType("view");
		shouquan_btn.setUrl(getAuthorUrl());
		
		zhiShiTest_btn.setName("֪ʶ����");//֪ʶ����
		zhiShiTest_btn.setSub_button(new Button[]{shouquan_btn});
		WeiKeTang_btn.setName("΢����");//΢����
		WeiKeTang_btn.setSub_button(new Button[]{button11});
		menu.setButton(new Button[]{zhiShiTest_btn,WeiKeTang_btn,weiPingTai_btn});
		return menu;
	}
	
	/**
	 * ��ʼ���˵�2
	 * @return
	 */
	public static Menu initMenu2(){
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("click�˵�");
		button11.setType("click");
		button11.setKey("11");
		ViewButton button21 = new ViewButton();
		button21.setName("view�˵�");
		button21.setType("view");
		button21.setUrl("http://www.baidu.com");
		ClickButton button31 = new ClickButton();
		button31.setName("ɨ���ά��");
		button31.setType("scancode_push");
		button31.setKey("31");
		ClickButton button32 = new ClickButton();
		button32.setName("����λ��");
		button32.setType("location_select");
		button32.setKey("32");
		Button[] button = new Button[]{button31,button32};
		Button button2 = new Button();
		button2.setName("�༶�˵�");
		button2.setSub_button(button);//���༶�˵����а���2���Ӳ˵�
		menu.setButton(new Button[]{button11,button21,button2});
		return menu;
	}
	/**
	 * �����˵�
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
	 * ��ȡaccess_token
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
	 * ��ȡ΢����ҳ��Ȩҳ������
	 * @return
	 */
	private static String getAuthorUrl(){
		String url = MessageUtil.urlEnCode("http://8icean.natappfree.cc/WxTestDemom/wx.do");//�ص�ҳ��ת��
		String authorUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";//��Ȩ��������
		authorUrl = authorUrl.replace("APPID", APPID).replace("REDIRECT_URI", url).replace("SCOPE","snsapi_userinfo");
		return authorUrl;
	}
}
