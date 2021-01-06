import java.util.Scanner;


public class Main {

	static int t;
	static int n, m;
	
	static String sit[];   

	static int dp[][];
	static int cases;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		while(t-- > 0) {
		
			n = sc.nextInt();
			m = sc.nextInt();
			
			sit = new String[n];
			
			for(int i = 0 ; i < n ; i++) {
				sit[i] = bitmasking(sc.next());
			}
			
			solve();
		}
		
		sc.close();

	}
	
	public static String bitmasking(String str) {
		
		String temp = "0";
		
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) == '.') temp += '1';
			else temp += '0';
		}
		temp+= '0';
		return temp;
		
	}
	
	public static String zero(String str) {

		String temp = str;

		for(int i = 0 ; i < m + 1 - str.length(); i++) {
			temp = 0 + temp;
		}
		temp += 0;
		return temp;

	}
	
	public static String zero(int str) {

		String temp = Integer.toBinaryString(str);
		int length = temp.length();
		
		for(int i = 0 ; i < m + 1 - length; i++) {
			temp = 0 + temp;
		}
		temp += 0;
		return temp;

	}
	
	public static void solve() {      
		
		cases = (int)Math.pow(2, m);
		dp = new int[n][cases];
		
		
		int result = 0;
		
		for(int i = 0 ; i < cases ; i ++) {
			
			String code = zero(i);
			int num = codeCompare(code, sit[0]);
			dp[0][i] = num;
			
			if(result < num) result = num;
		}
		
		for(int dpNum = 1 ; dpNum < n ; dpNum++) {
			for(int i = 0 ; i < cases ; i++) {
				
				String code = zero(i);
				
				int num = codeCompare(code, sit[dpNum]);
				int preNum = preCompare(code, dpNum);
				
				dp[dpNum][i] = num + preNum;
				
				if(result < dp[dpNum][i]) result = dp[dpNum][i];
				
			}
		}
		System.out.println(result);
	}
	
	public static boolean preCondition(String code, int i) {
		
		String compareCode = zero(i);
		
		for(int j = 1; j < code.length() - 1 ; j++) {
			if(code.charAt(j) == '1') {
				if(compareCode.charAt(j-1) == '1' || compareCode.charAt(j+1) == '1') {
					return false;
				}
			}
		}
		return true;
	}
	public static int preCompare(String code, int level) {
		
		int temp = 0;
		
		for(int i = 0 ; i < cases ; i++) {
			if(preCondition(code, i)) {
				int num = dp[level-1][i];
				if(temp < num) temp = num;
			}
		}
		return temp;
	}

	public static int codeCompare(String code, String layout) {
		
		for(int i = 1 ; i < code.length() -1 ; i++) {
			if(code.charAt(i) == '1') {
				if(code.charAt(i+1) == '1' || layout.charAt(i) == '0') {
					return 0;
				}
			}
		}
		return bitCount(code);
	}
	
	public static int bitCount(String code) {
		int num = 0;
		for(int i = 1 ; i <code.length() -1 ; i++ ) {
			if(code.charAt(i) == '1') num++;
		}
		return num;
	}
	
	

}




















