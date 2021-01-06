package test;

import java.util.HashMap;

public class test3 {
	public static void main(String[] args) {
		
		
		HashMap<Integer, Integer> infoMap = new HashMap<Integer, Integer>();
		
		Object test = 1;
		
		infoMap = (HashMap<Integer, Integer>) test;
		
		System.out.println(infoMap.get(1));
		
	}
}
