package example3;

import java.util.Scanner;

public class MainMenu {
	private static String MenuList[];
	
	static{		
		String MenuList[] ={"[��ǰ ���� ���α׷�]",				
							"1.��ǰ����",
							"2.����/���",
							"3.������",
							"4.����"};	
		
		MainMenu.MenuList = MenuList;
	}
	
	static int MenuSelector()
	{		
		for(int i = 0; i< MenuList.length ; i++) {
			System.out.println(MenuList[i]);					
		}		
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȣ�� �Է����ּ���: ");
		return sc.nextInt();		
	}	
	
}
