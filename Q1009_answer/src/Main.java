import java.util.Scanner;

public class Main {
//	�ٸ� ���
//	��� ������ ���� �Ŀ� ������ �ѹ��� ���ϴ� ��� �ӵ��� ����
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
//	���ϱ��� ���� �ݺ����� �̿��Ͽ� ������ ���� ���� �����ϴ� ���
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
