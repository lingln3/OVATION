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
				out("输入格式错误，请输入“SET”或“RESET”！");
				return false;
			}
		}
	}
}
