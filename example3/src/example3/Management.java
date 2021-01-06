package example3;

public class Management {
	
	static void selectNum()
	{
		
		boolean endFlag = true;
		
		while(endFlag == true)
		{
			int num = ManagementMenu.MenuSelector();
			
			switch (num) {
			case 1:
				
				break;
			case 2:
				
				break;
			default:
				endFlag = false;
				break;
			}
			
		}
	}
	
}
