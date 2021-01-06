package Q1003.fibonacci;

public class Fibonacci {

	
	
	static int zeroCount = 0;
	static int oneCount = 0;
	
	
	public static void main(String[] args) {
		
		
		System.out.println("fibonacci: "+fibonacci(3) +" zeroCount: "+ zeroCount + "  oneCount: "+ oneCount);
		
	}
	
	private static int fibonacci(int num) {
		
		if(num == 0) {
			zeroCount++;
			return 0;
		}
		else if(num == 1) {
			oneCount++;
			return 1;
		}
		
		return fibonacci(num - 2) + fibonacci(num -1);				
		
	}
	
	
}
