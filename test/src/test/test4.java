package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test4 {
	public static void main(String[] args) {

		String str = "±×·¡³ª´Ù ±×·¡µµ ."
				+ ".°¡³ª´Ù(°í±â´Â) 010-5036-6155";

		Matcher mt = Pattern.compile("(^[°¡-Èþ]+)|([°¡-Èþ]+)(?=\\()|([°¡-Èþ]+)(?=\\))|\\d{2,3}-\\d{3,4}-\\d{4}").matcher(str);

		while (mt.find()) {
			System.out.println("=====");
			System.out.println(mt.group());
			System.out.println("=====");
		}

//		str = "https://www.netflix.com/watch/81028719?trackId=155573560/tester";
//		str = "https://www.youtube.com/watch?v=ybOdWlb0aLI";
//	
//		mt = Pattern.compile("((\\w+)(?=://))|(w{3}.\\w+.com)|(([=?]?[0-9a-zA-Z°¡-Èþ]+)+)").matcher(str);
//
//		while (mt.find()) {
//			System.out.println(mt.group());
//			System.out.println("=====");
//		}

//		System.out.println("22222");
//		
//		mt = Pattern.compile("(\\w+(?!/)$)").matcher(str);
//
//		while (mt.find()) {
//			System.out.println(mt.group());
//			System.out.println("=====");
//		}
//		
		

	}
}
