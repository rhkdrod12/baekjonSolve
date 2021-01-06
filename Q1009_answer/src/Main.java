import java.util.Scanner;

public class Main {
//	다른 방식
//	모든 제곱을 진행 후에 마지막 넘버를 구하는 방식 속도가 느림
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int testCase;
//		
//		testCase = sc.nextInt();
//		
//		while(testCase-- > 0) {
//			
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			
//			int temp = 1;			
//			for(int i = 1 ; i <= b ; i++) {
//				temp *= a;
//				temp %= 10;				
//			}
//			if(temp == 0) temp = 10;
//			
//			System.out.println(temp);
//		}	
//		
//		sc.close();
//	}
//	곱하기의 수가 반복됨을 이용하여 마지막 나올 수를 예측하는 방식
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testCase;
		
		testCase = sc.nextInt();
		
		while(testCase-- > 0) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int temps[] = new int[4];	
			
			int temp = 1;			
			
			for(int i = 0 ; i < 4 ; i++) {
				
				temp *= a;
				temp %= 10;
				
				if(temp == 0) temp = 10;
				temps[i] = temp;
												
			}
			System.out.println(temps[(b-1)%4]);
		}	
		
		sc.close();
		
		
	}
}
