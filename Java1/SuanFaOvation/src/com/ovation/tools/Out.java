package com.ovation.tools;

public class Out {
	public static void out(String s){
		System.out.println(s);
	}
	
	public static boolean fromStrToBool(String s){
		switch(s.toUpperCase()){
		case "TRUE":
			return true;
		case "FALSE":
			return false;
			default:{
				out("�����ʽ���������롰SET����RESET����");
				return false;
			}
		}
	}
}
