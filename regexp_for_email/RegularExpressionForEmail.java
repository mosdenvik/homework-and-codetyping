package regexp_for_email;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionForEmail {
	public static void main(String[] args) {
		String str = "Address of e-mail: mosdenvik.nd@gmail.com, nickolas_rector@yahoo.com.ua";
		String regex = "(\\w{3,})(.|_)(\\w{0,})@(\\w+\\.)([a-z]{2,4})(.)(\\w{0,})";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			System.out.println("e-mail: " + matcher.group());
		}
	}
}
