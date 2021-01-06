import java.util.Scanner;

public class Main {

	static int t;
	static char sits[][];

	static String sit[];   
	static int n, m;

	static int dp[][];

	

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
		
		
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		sit = new String[n];
		
		for(int i = 0 ; i < n ; i++) {
			sit[i] = bitmasking(sc.next());
		}
		
		compare();

	}

	public static void solve() {



	}
	
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
	public static int compare() {      

		//dp[n][l] n = 열  l = 배치도(5이면  0101이므로)
		//이 배치도가 가능하지 판단하는 기준은 
		//
		//첫번째
		//배치도에서 1인 곳의 양 옆에 1이 아닌 경우만 가능

		//두번째
		//양옆을 비교하고나서는 이전것과 비교해야함
		//좌대각선, 우대각선이 있는지를 판단해야함
		
		String able[] = new String[(int)Math.pow(2, m)];
		dp = new int[n][(int)Math.pow(2, m)];
		int temp = 0;
		
		
		for(int i = 0 ; i < (int)Math.pow(2, m) ; i++) {
			able[i] = sumAble(zero(Integer.toBinaryString(i)));
			
			String code = zero(Integer.toBinaryString(i));
			
			if(codeCondition(code, sit[0])) {
				int temp2 = count(code);
				dp[0][i] = temp2; 
				if(temp < temp2) temp = temp2;
				System.out.println("code: "+code + " dp: " + dp[0][i]);
			}
			
			System.out.printf("able[%d]: %s\n", i , able[i]);
		}
		
		for(int i = 1 ; i < n ; i++) {
			for(int j = 0 ; j < (int)Math.pow(2, m); j++) {
				String code = zero(Integer.toBinaryString(j));
				if(codeCondition(code, sit[i])) {
					for(int k = 0 ; k < able[i].length(); k++) {
						if(able[i].charAt(k) == '1') {
							int temp2 = dp[i-1][j] + count(code);
							dp[i][j] = temp2;
							if(temp < temp2) temp = temp2;
							System.out.println("code: "+code + " dp: " + dp[i][j] + " temp: " + temp);
	//						System.out.println("code: " + code + " temp: " + temp);
						}
					}
				}
			}			
		}
		System.out.println("count: " + (int)Math.pow(2, m));
		System.out.println(temp);
		return 0;
	}
	
	public static String sumAble(String code) {
		String num = "";
		for(int i = 0 ; i < (int)Math.pow(2, m) ; i++) {
			if(preCondition(zero(Integer.toBinaryString(i)), code)) num += 1;
			else num+=0;
		}
		return num;
	}
	
	public static int count(String code) {
		int num = 0;
		for(int i = 1 ; i <code.length() -1 ; i++ ) {
			if(code.charAt(i) == '1') num++;
		}
		return num;
	}
	
	public static boolean preCondition(String code, String layout) {
		
		for(int i = 1 ; i < code.length() - 1 ; i++) {
			//target이 1인 경우에
			if(code.charAt(i) == '1') {
				if(layout.charAt(i-1) == '1' || layout.charAt(i+1) == '1'){
					return false;
				}
			}
		}
		return true;
	}
	public static boolean codeCondition(String code, String layout) {
		//설정된 값과 판단 값이 서로 같은지 판단
		//layout안의 1에만 배치 가능한 것이므로 
		//layout이 0인데 code가 1이면 사용불가능
		for(int i = 1 ; i < code.length() -1 ; i++) {
			//target이 1인 경우에
			if(code.charAt(i) == '1') {
				//그 다음에 0이 없는지 확인
				if(code.charAt(i+1) == '1' || layout.charAt(i) == '0') {
					return false;
				}
			}
		}

		return true;
	}
	public static String zero(String str) {

		String temp = str;

		for(int i = 0 ; i < m + 1 - str.length(); i++) {
			temp = 0 + temp;
		}
		temp += 0;
		return temp;

	}

}




















