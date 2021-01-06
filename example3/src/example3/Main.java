package example3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean endFlag = true;
		
		while(endFlag == true)
		{			
			int num = MainMenu.MenuSelector();
			
			switch(num)
			{
			case 1:
				Management.selectNum();				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				endFlag = false;
				break;
			}
			
		}	
		
	}

}
