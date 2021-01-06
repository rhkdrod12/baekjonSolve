import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.print.attribute.standard.Fidelity;


public class Main {

	static int t;
	static int n, m;
	
	static String sit[];   

	static int dp[][];
	static int codeCaseAble[];
	static int codeCaseAbleNum;
	static int codeCaseAll;
	static int codeCasePre[][];
	
	
	public static void main(String[] args) {
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
		
		sc.close();
	}
	
	// 풀기
	public static void solve() {      
		
		//코드케이스 분류
		
		//0.총 가능한 코드케이스
		codeCaseAll = (int)Math.pow(2, m);
		
		//1.codeCase 중에서 사용가능한 코드케이스 찾기, codeCase의 비트값(정수)를 보관
		codeCaseAble = findCodeCase();
		System.out.println(Arrays.toString(codeCaseAble) + codeCaseAble.length);
		codeCaseAbleNum = codeCaseAble.length;
		
		//2.codeCase에 따른 사용가능한 이전 코드케이스 찾기, codeCaseAble의 위치를 보관하고 있음
		codeCasePre = new int[codeCaseAbleNum][];
		for(int i = 0 ; i < codeCaseAbleNum; i++) {
			codeCasePre[i] = findPreCodeCase(i);
		}
		
		//3.dp공간부여
		dp = new int[n][codeCaseAbleNum];
		int result = 0;
		
		//4.dp[0]값 입력
		for(int i = 0 ; i < codeCaseAbleNum ; i++) {
			dp[0][i] = codeCompare(zero(codeCaseAble[i]), sit[0]);
			if(result < dp[0][i]) result = dp[0][i];
			System.out.printf("code: %s\tnum: %d\tresult: %d\n", zero(codeCaseAble[i]), dp[0][i], result);
		}
		
		//5.dp[n]값 입력하기, 
		for(int i = 1 ; i < n ; i++) {
			for(int j = 0 ; j < codeCaseAbleNum ; j++) {
				
				int num = codeCaseAble[j];
				
				int testnum = codeCompare(zero(num), sit[i]);
				int testpreNum = preCompare(i, j);
				
				dp[i][j] = codeCompare(zero(num), sit[i]) + preCompare(i, j);
				if(result < dp[i][j]) result = dp[i][j];
				
				System.out.printf("code: %s\tnum: %d\tpreNum: %d\n",zero(i) ,testnum, testpreNum);
			}
		}
		
		System.out.println(result);
	}
	
	
	public static int preCompare(int i, int codeNum) {
		
		int temp = 0;
		for(int num : codeCasePre[codeNum]) {
			if(temp < dp[i-1][num]) temp = dp[i-1][num];
		}
		return temp;
	}
	
	//3. 배치도와에 맞추어 배치가 가능하면 입력
	public static int codeCompare(int codeCase, int layout) {
		
		int num = 0;
		
		for(int i = 1 ; i < codeCase.length() -1 ; i++) {
			//target이 1인 경우에
			if(codeCase.charAt(i) == '1') {
				//그 다음에 0이 없는지 확인
				if(codeCase.charAt(i+1) == '1' || layout.charAt(i) == '0') {
					return 0;
				}
				num++;
			}
		}
		return num;
	}

	public static int codeCompare(String codeCase, String layout) {
		
		int num = 0;
		
		for(int i = 1 ; i < codeCase.length() -1 ; i++) {
			//target이 1인 경우에
			if(codeCase.charAt(i) == '1') {
				//그 다음에 0이 없는지 확인
				if(codeCase.charAt(i+1) == '1' || layout.charAt(i) == '0') {
					return 0;
				}
				num++;
			}
		}
		return num;
	}
	
	//2. 해당 코드케이스에 따른 사용가능한 코드케이스 찾기
	public static int[] findPreCodeCase(int numCase) {
		String codeCase = "";
		for(int i = 0 ; i < codeCaseAbleNum ; i++) {
			if(ablePreCodeCase(numCase, codeCaseAble[i])) {
				codeCase += i+":";
			}
		}
		return Stream.of(codeCase.split(":")).mapToInt(Integer::parseInt).toArray();
	}
	
	public static boolean ablePreCodeCase(int numCase, int preCase) {
		String codeCase = zero(numCase);
		String preCodeCase = zero(preCase);
		
		for(int j = 1; j < codeCase.length() - 1 ; j++) {
			if(codeCase.charAt(j) == '1') {
				if(preCodeCase.charAt(j-1) == '1' || preCodeCase.charAt(j+1) == '1') {
					return false;
				}
			}
		}
		return true;
	}
		
	//1. 사용가능한 코드케이스 찾기
	public static int[] findCodeCase() {
		String codeCase = "";
		
		for(int i = 0 ; i < codeCaseAll ; i++) {
			if(ableCodeCase(i)) {
				codeCase += i+":";
			}
		}
		return Stream.of(codeCase.split(":")).mapToInt(Integer::parseInt).toArray();
	}
	
	//해당 코드케이스가 사용가능한지 판단
	public static boolean ableCodeCase(int numCase) {
		String codeCase = Integer.toBinaryString(numCase);
		for(int j = 0 ; j < codeCase.length() - 1 ; j++) {
			if(codeCase.charAt(j) == '1' && codeCase.charAt(j+1) == '1') {
				return false;
			}
		}
		System.out.println("code: " + codeCase);
		return true;
	}
	
	// 문자를 0과 1로 치환후 양 옆에 0을 붙임
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
	public static String zero(int num) {

		String temp = Integer.toBinaryString(num);
		int length = temp.length();
		
		for(int i = 0 ; i < m + 1 - length; i++) {
			temp = 0 + temp;
		}
		temp += 0;
		return temp;

	}

	
	//해당 코드케이스에 사용가능한 이전 레벨 코드케이스 찾기
	
	

}




















