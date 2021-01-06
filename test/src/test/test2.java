package test;

import java.util.Arrays;

public class test2 {
	public static void main(String[] args) {

		int [] arr1 = new int[]{1,2,3,4,5};
		int [] arr2 = {1,2,3,4,5};
		int [] arr3 = arr1;
		
		System.out.println(arr1.equals(arr3));
		System.out.println(Arrays.equals(arr1, arr2));

	}

}

@FunctionalInterface
interface Say{
	int someting(int a,int b);
}

class Person{
	public void hi(Say line) {
		int number = line.someting(3,4);
		System.out.println("Number is "+number);
	}
}