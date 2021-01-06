import java.util.Scanner;


public class Main {

	static int t;
	static int n, m;
	
	static String sit[];   

	static int dp[][];
	static int cases;
	

	public static void main(String[] args) {
		/*
		 * t : 테스트케이스
		 * n : 세로길이
		 * m : 가로길이
		 * . : 앉을 수 있는 자리
		 * x : 앉을 수 없는 자리
		 * 
		 */
			
		Scanner sc = new Scanner(System.in);
		
		n = 10;
		m = 10;
		
		sit = new String[n];
		//....x.....
		sit[0] = "011110111110";
		sit[1] = "011111111110";
		sit[2] = "011111111110";
		sit[3] = "011011111110";
		sit[4] = "011111111110";
		sit[5] = "001110101110";
		sit[6] = "011111111100";
		sit[7] = "011101111110";
		sit[8] = "011111111010";
		sit[9] = "010111011110";
		
		solve();

	}
	
	// . , x 를 1 또는 0 으로 치환, 양 옆에 0을 추가 
	public static String bitmasking(String str) {
		String temp = "0";
		
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) == '.') temp += '1';
			else temp += '0';
		}
		temp+= '0';
		System.out.println(temp);
		return temp;
	}
	// 값을 입력받아 자리에 맞추어 0을 붙인 후 양 옆에 0을 붙임
	public static String zero(String str) {

		String temp = str;

		for(int i = 0 ; i < m + 1 - str.length(); i++) {
			temp = 0 + temp;
		}
		temp += 0;
		return temp;

	}
	// 숫자를 입력받아 비트로 치환 후 양 옆에 0을 붙임
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
		
		//경우의 수
		cases = (int)Math.pow(2, m);
		//각 레벨에 따라 가능한 경우의 수 저장
		String dpAble[] = new String[cases];
		//dp 각 레벨에 따라 가능한 경우에 따른 배치가능한 학생의 수의 합
		dp = new int[n][cases];
		
		int result = 0;
		//현재 레벨에 배치 가능한 경우를 찾기 
		//경우의 수를 code, 배치가능한 자리를 layout으로 사용
		//코드와 layout 양옆에는 0이 부여되어 있음
		
		//처음에는 배치 가능하면 모두 배치 가능
		//각 경우의 수를 돌리면서 dp[0]에 저장
		for(int i = 0 ; i < cases ; i ++) {
			
			String code = zero(i);
			int num = codeCompare(code, sit[0]);
			dp[0][i] = num;
			
			if(result < num) result = num;
			System.out.printf("level: %4d  code: %s  layout: %s  num: %4d  result: %4d\n", i, code, sit[0], num, result);
		}
		
		//n>0 일때 dp[n] 은  dp[n-1]도 고려해야함
		for(int dpNum = 1 ; dpNum < n ; dpNum++) {
			for(int i = 0 ; i < cases ; i++) {
				
				String code = zero(i);
				int num = codeCompare(code, sit[dpNum]);
				int preNum = preCompare(code, dpNum);
				dp[dpNum][i] = num + preNum;
				
				//해당 code가 과거 레벨의 경우의 수에서 사용가능한 경우를 찾아 합이 가장 큰 경우를 반환하게
				if(result < dp[dpNum][i]) result = dp[dpNum][i];
				System.out.printf("level: %4d  code: %s  layout: %s  num: %4d preNum: %4d result: %4d\n", i, code, sit[dpNum], num, preNum,result);
				
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
		
		int num = 0;
		
		for(int i = 1 ; i < code.length() -1 ; i++) {
			//target이 1인 경우에
			if(code.charAt(i) == '1') {
				//그 다음에 0이 없는지 확인
				if(code.charAt(i+1) == '1' || layout.charAt(i) == '0') {
					return 0;
				}
				num++;
			}
		}
		return num;
	}
	

}




















