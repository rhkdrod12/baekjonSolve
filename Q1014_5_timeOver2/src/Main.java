import java.util.Scanner;


public class Main {

	static int t;
	static int n, m;
	
	static String sit[];   

	static int dp[][];
	static int codeCases;
	

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
	
	// 풀기
	public static void solve() {      
		
		codeCases = (int)Math.pow(2, m);
		dp = new int[n][codeCases];
		
		
		int result = 0;
		//지금 모든 경우의 수를 매번 판단해버리기 떄문에 시간 초과가 나는거 같은데 
		//그러면 되겠네 배치에 따라섯 001101010101011 이렇게?
		//String을 :으로 분류하여 스플릿을 사용하는게 좋으려나..
		
		
		//dp[0] 입력
		for(int i = 0 ; i < codeCases ; i ++) {
			
			String code = zero(i);
			int num = codeCompare(code, sit[0]);
			dp[0][i] = num;
			
			if(result < num) result = num;
		}
		
		//dp[1] 이상 입력
 		for(int dpNum = 1 ; dpNum < n ; dpNum++) {
			for(int i = 0 ; i < codeCases ; i++) {
				
				String code = zero(i);
				
				int num = codeCompare(code, sit[dpNum]);
				int preNum = preCompare(code, dpNum);
				
				dp[dpNum][i] = num + preNum;
				
				if(result < dp[dpNum][i]) result = dp[dpNum][i];
				
			}
		}
		System.out.println(result);
	}
	
	//현재의 경우에 사용가능한 이전 경우의 수들 구하기
	public static String CodeDecision(int codeCase) {
		String code = zero(codeCase);
		
		for(int i = 0 ; i < codeCases ; i++) {
			
		}
		
		
		return null;
	}
	
	// 문자를 0과 1로 치환
	public static String bitmasking(String str) {
		
		String temp = "0";
		
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) == '.') temp += '1';
			else temp += '0';
		}
		temp+= '0';
		return temp;
		
	}
	
	// 숫자를 입력받아서 비트로 치환 후 양 옆에 0을 붙임
	public static String zero(int str) {

		String temp = Integer.toBinaryString(str);
		int length = temp.length();
		
		for(int i = 0 ; i < m + 1 - length; i++) {
			temp = 0 + temp;
		}
		temp += 0;
		return temp;

	}
	
	//해당 코드케이스에 사용가능한 이전 레벨 코드케이스 찾기
	public static int[] caseConditon(String codeCase) {
		
		int temp[] = new int[codeCases];
		
		for(int i = 0 ; i < codeCases ; i++) {
			if(preCondition(codeCase, i)) {
				temp[i] = i;
			}
		}
		
		return temp;
	}
	
	
	// 해당 코드에 이어 붙일 수 있는 이전 레벨의 경우의 수
	public static boolean preCondition(String codeCase, int preCodeCase) {
		
		String compareCode = zero(preCodeCase);
		
		for(int j = 1; j < codeCase.length() - 1 ; j++) {
			if(codeCase.charAt(j) == '1') {
				if(compareCode.charAt(j-1) == '1' || compareCode.charAt(j+1) == '1') {
					return false;
				}
			}
		}
		return true;
	}
	
	// 현재 코드에서 이전 레벨의 선택 가능한 경우의 수에서 가장 큰 배치 수를 찾기
	public static int preCompare(String codeCase, int level) {
		
		int temp = 0;
		
		for(int i = 0 ; i < codeCases ; i++) {
			if(preCondition(codeCase, i)) {
				int num = dp[level-1][i];
				if(temp < num) temp = num;
			}
		}
		return temp;
	}
	
	// 배치도에 따른 배치 가능한 경우의 수에 따른 학생수 찾기
	public static int codeCompare(String codeCase, String layout) {
		
		for(int i = 1 ; i < codeCase.length() -1 ; i++) {
			if(codeCase.charAt(i) == '1') {
				if(codeCase.charAt(i+1) == '1' || layout.charAt(i) == '0') {
					return 0;
				}
			}
		}
		return bitCount(codeCase);
	}
	
	// 코드에 따른 배치 수 반환
	public static int bitCount(String codeCase) {
		int num = 0;
		for(int i = 1 ; i <codeCase.length() -1 ; i++ ) {
			if(codeCase.charAt(i) == '1') num++;
		}
		return num;
	}
	
	

}




















