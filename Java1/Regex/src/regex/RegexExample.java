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
		System.out.println("�ַ������Ƿ������'runoob'�ַ�����"+isMatch);
		System.out.println("�ַ������Ƿ��Դ�д��ĸ��ʼ��"+isMatch2);
	}
}
