package example3;

import java.util.Scanner;

public class ManagementMenu {

	private static String MenuList[];
	
	static{				
		String MenuList[] ={"[力前 包府]",				
							"1.力前殿废",
							"2.力前昏力",
							"3.辆丰"};	
		
		ManagementMenu.MenuList = MenuList;
	}
	
	static int MenuSelector()
	{		
		for(int i = 0; i< MenuList.length ; i++) {
			System.out.println(MenuList[i]);					
		}		
		Scanner sc = new Scanner(System.in);
		System.out.println("锅龋甫 涝仿秦林技夸: ");
		return sc.nextInt();		
	}
	
	
	
}
