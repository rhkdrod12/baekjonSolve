package example3;

import java.util.Scanner;

public class ManagementMenu {

	private static String MenuList[];
	
	static{				
		String MenuList[] ={"[��ǰ ����]",				
							"1.��ǰ���",
							"2.��ǰ����",
							"3.����"};	
		
		ManagementMenu.MenuList = MenuList;
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
