package example2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str = "1123+12123.12+123.112+(1234+11223)*12";
		String data[] =  new String[50];
		int top = 0;
		boolean flag = false;
		
		
		for(int i = 0; i<data.length; i++)
		{
			data[i] = "";
		}
		
		System.out.println("test");
		for(int i = 0; i<str.length(); i++)
		{
			char temp = str.charAt(i);
			
			if(temp >= '0' && temp <= '9' || temp == '.')
			{
				if(flag)
				{
					top++;
					flag = false;
				}
				data[top] += temp;
				
			}
			else
			{
				top++;
				flag = true;
				data[top] += temp;
				
			}
			
		}
		
		System.out.println(Arrays.toString(data));
		
		
		
		
	}

}
