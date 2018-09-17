package com.mytest.util;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 该util文档主要用于校验
 * @author snpas
 *
 */
public class CheckUtil {
	private static final String token = "mytoken";
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] arr = new String[]{token,timestamp,nonce};
		//排序
		Arrays.sort(arr);
		
		//生成字符串，拼接成字符串
		StringBuffer content = new StringBuffer();
		for(int i=0; i<arr.length; i++){
			content.append(arr[i]);
		}
		
		//SHA1加密，该方法网上很多，直接下载即可
		String temp = getSha1(content.toString());
		//将sha1加密结果与微信传递过来的加密信息进行比较
		return temp.equals(signature);
	}
	 public static String getSha1(String str){
	        if(str==null||str.length()==0){
	            return null;
	        }
	        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
	                'a','b','c','d','e','f'};
	        try {
	            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	            mdTemp.update(str.getBytes("UTF-8"));
	            byte[] md = mdTemp.digest();
	            int j = md.length;
	            char buf[] = new char[j*2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                buf[k++] = hexDigits[byte0 & 0xf];      
	            }
	            return new String(buf);
	        } catch (Exception e) {
	            // TODO: handle exception
	            return null;
	        }
	    }
}
