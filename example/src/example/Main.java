package example;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("°ª ÀÔ·Â: ");
		String str = sc.next();
		
		
			st.push(str.charAt(i));					
		
		st.printStack();		
		
	}

}

class Calculator
{
	
	StackChar st = new StackChar();
	StackInt sti = new StackInt();
	
	void inputData(String str)
	{
		
		double num = 0;
		boolean flag = true;
		int count = 0;
		
		for(int i = 0; i < str.length(); i++)		
		{
			char temp = str.charAt(i);
						
			if(temp >= '0' && temp <= '9')		
			{
				if(flag)
					num = num*10 + (int)temp - 48;
				else
				{
					count++;
					num += ((int)temp - 48)/(10 * count);
				}
			}
			
			else if(temp == '.')
				flag = false;
			
			else if(temp >= '(' && temp <= '/')
			{
				
			}
			
		}
	}
}

