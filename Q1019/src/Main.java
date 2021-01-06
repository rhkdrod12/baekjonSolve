import java.util.Scanner;

public class Main {
	
	static long[] num = new long[10];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		solve(N);
		
		for(int i = 0 ; i < num.length ; i++) {
			System.out.printf("%2d ", i);
		}
		System.out.println();
		for(int i = 0 ; i < num.length ; i++) {
			System.out.printf("%d ", num[i]);
		}
	}
	static void solve(int N) {
		int size = (int)(Math.log10(N) + 1);
		
		for(int i = size ; i > 0 ; i--) {
			
			int sub = (int)Math.pow(10, (i - 1));
			
			int val = (N/sub)%10;
			int fntVal = N/(sub*10);
			int bckVal = N%sub;
			int temp = 0;
			
			if(val > 0)
				temp = (N/(sub*10))*sub;
			else
				temp = (N/(sub*10));
			
			num[0] +=temp;
			
			System.out.printf("sub : %3d size: %3d num[0]: %3d", sub ,i , temp);
			System.out.printf(" val: %3d fntVal: %3d bckVal: %3d", val, fntVal, bckVal);
			
			int j;
			
			for(j = 1 ; j <= 9 ; j++ ) {
				
				
				temp = 0;
				if(j < val || val == 9) {
					temp = (fntVal + 1)*sub;
				}
				else if(j == val && val < 9) {
					temp = (fntVal)*sub + bckVal + 1;
				}
				else {
					temp = fntVal*sub;
				}
				
				System.out.printf(" num[%d]: %3d", j , temp);
				
				num[j] += temp;
			}
			System.out.println();
		}
	}

	
	
}
