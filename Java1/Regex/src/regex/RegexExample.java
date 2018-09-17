package regex;

import java.util.regex.Pattern;

public class RegexExample {
	public static void main(String[] args){
		String content = "I am noob"+
					"from runoob.com";
		String parttern = ".*runoob.*";
		String pattern2 = "[A-Z]{1,}";
		boolean isMatch = Pattern.matches(parttern, content);
		boolean isMatch2 = Pattern.matches(pattern2, content);
		System.out.println("字符串中是否包含了'runoob'字符串？"+isMatch);
		System.out.println("字符串中是否以大写字母开始？"+isMatch2);
	}
}
