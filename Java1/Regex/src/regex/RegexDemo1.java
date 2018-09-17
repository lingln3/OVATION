package regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo1 {
	public static void main(String[] args) throws IOException{
		BufferedReader in;
		Pattern pattern = Pattern.compile("//(//d{3}//)/s//d{3}-//d{4}");
		in = new BufferedReader(new FileReader("phone"));
		String s;
		while((s = in.readLine())!=null){
			Matcher matcher = pattern.matcher(s);
			if(matcher.find()){
				System.out.println(matcher.group());
			}
		}
		in.close();
	}
}
