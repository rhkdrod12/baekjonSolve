import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		Quest qu = new Quest();		
		qu.quest();
		
	}
}


class Quest{
	
	
	int testCase;
	
	int area;
	int areaEnemy[][];
		
	int specialForce;		
	
	int dp[][];
	
	final int INF = (int) Double.POSITIVE_INFINITY - 10;
	
	
	public void quest() {
				
		Scanner	sc;				
		sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		for(int test = 0 ; test < testCase ; test ++) {
			
			area = sc.nextInt();
			specialForce = sc.nextInt();
					
			areaEnemy = new int[2][area + 1];
			
			for(int i = 0; i < 2 ; i++) {				
				for(int j = 1; j < area + 1; j++) {
					areaEnemy[i][j] = sc.nextInt();
				}			
			}			
			
			int ans = INF;
			
			if(area <= 1) {
				ans = min(ans, (areaEnemy[0][1] + areaEnemy[1][1])> specialForce?2:1);
			}			
			else {
				
				dp = new int[3][area + 1];	
							
				//n번째와 0번째가 겹치는 경우가 없을 때
				dp[0][1] = 1;
				dp[1][1] = 1;
				dp[2][1] = (areaEnemy[0][1] + areaEnemy[1][1])> specialForce?2:1;
				
				solve();		
				ans = dp[2][area];
				
				//위쪽라인이 하나 겹칠 때
				if(areaEnemy[0][area] + areaEnemy[0][1] <= specialForce) {		
					dp[2][0] = INF;		
					dp[0][1] = 1;	
					dp[1][1] = INF;
					dp[2][1] = 2;							
					
					solve();
					ans = min(ans, dp[1][area]);
					
				}
							
				//아래쪽라인이 하나 겹칠 때
				if(areaEnemy[1][area] + areaEnemy[1][1] <= specialForce) {
					dp[2][0] = INF;				
					dp[0][1] = INF;
					dp[1][1] = 1;	
					dp[2][1] = 2;
					
					solve();
					ans = min(ans, dp[0][area]);
					
				}			
				
				//둘다 겹칠 때 
				if(areaEnemy[0][area] + areaEnemy[0][1] <= specialForce && areaEnemy[1][area] + areaEnemy[1][1] <= specialForce) {
					dp[2][0] = INF;
					dp[0][1] = INF;
					dp[1][1] = INF;	
					dp[2][1] = 2;
					
					solve();
					ans = min(ans, dp[2][area - 1]);
				}		
			}
			System.out.println(ans);	
		}
		
		sc.close();	
	}
	
	
	public void solve() {
		
		for(int n = 2; n <= area ; n++) {
		
			int outer = ((areaEnemy[1][n-1] + areaEnemy[1][n])> specialForce?2:1);
			int inner = ((areaEnemy[0][n-1] + areaEnemy[0][n])> specialForce?2:1); 
			int horizon = ((areaEnemy[0][n] + areaEnemy[1][n])> specialForce?2:1); 		
					
			dp[0][n] = min(dp[1][n-1] + inner, dp[2][n-1] + 1);
			dp[1][n] = min(dp[0][n-1] + outer, dp[2][n-1] + 1);
			dp[2][n] = min(dp[0][n] + 1, dp[1][n] +1, dp[2][n-1] + horizon, dp[2][n-2] + outer + inner);			
			
		}
	}	
	
	public int min(int... val){		
		int temp = 0;		
		temp = val[0];			
		for(int i = 1; i< val.length; i++) {
			if(temp > val[i]) {
				temp = val[i];
			}
		}		
		return temp;
	}
	
}