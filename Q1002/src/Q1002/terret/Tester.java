package Q1002.terret;

public class Tester {
	
	
	public static void main(String[] args) {
		
//		System.out.println("test");
//		
//		int x = 1;
//		int y = 0;
//		
//		int r = 1;
//		int count = 0;
//				
//		/*
//		 * 좌표가 a, b일 때 거리가 r인경우의 좌표 경우 수
//		 * x축에서 가장 긴 곳은 a+r,b   or  a-r, b
//		 * y축에서 가장 긴 곳은 a, b+r  or  a, b-r
//		 * 
//		 * 실수는 의미 해당안되고 정수만 해당됨 
//		 * 
//		 * 
//		 */
//		
//		for(int i = x-r ; i <= x+r ; i++) {				
//			for(int j = y+r ; j >= y-r ; j--) {			
//				double val = Math.sqrt(Math.pow(x-i, 2) + Math.pow(y-j, 2));
//				if(r == val) {
//					System.out.printf("%d %d\n", i, j);
//					count++;
//				}				
//			}			
//		}
//		
//		System.out.println("count: "+ count);
		
		double a = 10.1;
		
		double b = 10.5;
		
		int result = Double.compare(a, b);
		
		System.out.println(result);
		
	}
}
