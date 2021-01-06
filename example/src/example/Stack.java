package example;

import java.util.Arrays;

class StackChar {

	private String data[] = new String[0];
		
	String pop(){
		
		String temp;
		temp = data[data.length - 1];
		stack_down();
		
		return temp;
	}
	
	void push(String ch){
		
		stack_up();
		data[data.length - 1] = ch;		
	}
	
	int length(){
		return data.length;
	}
	
	void printStack(){
		System.out.println(Arrays.toString(data));		
	}		
	
	private void stack_up(){
		
		String temp[] = new String[data.length+1];
		
		for(int i = 0; i < data.length; i++)		
			temp[i] = data[i];		
		
		data = temp;
	}
	
	private void stack_down() {
		
		String temp[] = new String[data.length-1];
		
		for(int i = 0; i < data.length - 1; i++)		
			temp[i] = data[i];		
		
		data = temp;
		
	}

}
