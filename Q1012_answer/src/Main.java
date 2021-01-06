import java.util.Scanner;

public class Main {
	
	static int t, m, n, k;
	static int lo[][];
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
				
		while(t-- > 0) {
			
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			lo = new int[m+2][n+2];
			
			for(int i = 0 ; i < k ; i++) {
				lo[sc.nextInt()+1][sc.nextInt()+1] = 1;
			}
			solve();
		}	
		sc.close();
		
	}
	
	static void solve() {
		
		int count = 0;
		
		for(int j = 1; j <= n ; j++) {
			for(int i = 1;  i <= m ; i++) {			
				if(lo[i][j] == 1) {
					change(i,j);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	
	static void change(int i, int j) {
		lo[i][j] = 2;
		
		if(lo[i-1][j] == 1) {
			change(i-1, j);
		}
		if(lo[i][j-1] == 1) {
			change(i, j-1);
		}
		if(lo[i+1][j] == 1) {
			change(i+1, j);
		}
		if(lo[i][j+1] == 1) {
			change(i, j+1);
		}
	}
}




