package example3;

import java.util.Scanner;

public class MainMenu {
	private static String MenuList[];
	
	static{		
		String MenuList[] ={"[제품 관리 프로그램]",				
							"1.제품관리",
							"2.생산/출고",
							"3.재고관리",
							"4.종료"};	
		
		MainMenu.MenuList = MenuList;
	}
	
	static int MenuSelector()
	{		
		for(int i = 0; i< MenuList.length ; i++) {
			System.out.println(MenuList[i]);					
		}		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 입력해주세요: ");
		return sc.nextInt();		
	}	
	
}
