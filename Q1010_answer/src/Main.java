import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Quest().input();
	}
}

class Quest{
	
	int t, n, m;
	int dp[][];
	
	public void input() {		
		Scanner sc = new Scanner(System.in);		
		t = sc.nextInt();		
		while(t-- > 0) {			
			n = sc.nextInt();
			m = sc.nextInt();				
			dp = new int[n + 1][m + 1];			
			solve();
		}			
		sc.close();
				
	}	
	public void solve() {		
		for(int i = 1 ; i <= m ; i++) {
			dp[1][i] = i;
		}		
		for(int i = 2 ; i <= n ; i++) {
			for(int j = i ; j <= m ; j++) {					
				dp[i][j] = dp[i-1][j-1] + dp[i][j-1];					
			}
		}		
		System.out.println(dp[n][m]);
	}
}