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
	
	// Ǯ��
	public static void solve() {      
		
		//�ڵ����̽� �з�
		
		//0.�� ������ �ڵ����̽�
		codeCaseAll = (int)Math.pow(2, m);
		
		//1.codeCase �߿��� ��밡���� �ڵ����̽� ã��, codeCase�� ��Ʈ��(����)�� ����
		codeCaseAble = findCodeCase();
		System.out.println(Arrays.toString(codeCaseAble) + codeCaseAble.length);
		codeCaseAbleNum = codeCaseAble.length;
		
		//2.codeCase�� ���� ��밡���� ���� �ڵ����̽� ã��, codeCaseAble�� ��ġ�� �����ϰ� ����
		codeCasePre = new int[codeCaseAbleNum][];
		for(int i = 0 ; i < codeCaseAbleNum; i++) {
			codeCasePre[i] = findPreCodeCase(i);
		}
		
		//3.dp�����ο�
		dp = new int[n][codeCaseAbleNum];
		int result = 0;
		
		//4.dp[0]�� �Է�
		for(int i = 0 ; i < codeCaseAbleNum ; i++) {
			dp[0][i] = codeCompare(zero(codeCaseAble[i]), sit[0]);
			if(result < dp[0][i]) result = dp[0][i];
			System.out.printf("code: %s\tnum: %d\tresult: %d\n", zero(codeCaseAble[i]), dp[0][i], result);
		}
		
		//5.dp[n]�� �Է��ϱ�, 
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
	
	//3. ��ġ���Ϳ� ���߾� ��ġ�� �����ϸ� �Է�
	public static int codeCompare(int codeCase, int layout) {
		
		int num = 0;
		
		for(int i = 1 ; i < codeCase.length() -1 ; i++) {
			//target�� 1�� ��쿡
			if(codeCase.charAt(i) == '1') {
				//�� ������ 0�� ������ Ȯ��
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
			//target�� 1�� ��쿡
			if(codeCase.charAt(i) == '1') {
				//�� ������ 0�� ������ Ȯ��
				if(codeCase.charAt(i+1) == '1' || layout.charAt(i) == '0') {
					return 0;
				}
				num++;
			}
		}
		return num;
	}
	
	//2. �ش� �ڵ����̽��� ���� ��밡���� �ڵ����̽� ã��
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
		
	//1. ��밡���� �ڵ����̽� ã��
	public static int[] findCodeCase() {
		String codeCase = "";
		
		for(int i = 0 ; i < codeCaseAll ; i++) {
			if(ableCodeCase(i)) {
				codeCase += i+":";
			}
		}
		return Stream.of(codeCase.split(":")).mapToInt(Integer::parseInt).toArray();
	}
	
	//�ش� �ڵ����̽��� ��밡������ �Ǵ�
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
	
	// ���ڸ� 0�� 1�� ġȯ�� �� ���� 0�� ����
	public static String bitmasking(String str) {
		
		String temp = "0";
		
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) == '.') temp += '1';
			else temp += '0';
		}
		temp+= '0';
		return temp;
		
	}
	
	// ���ڸ� �Է¹޾Ƽ� ��Ʈ�� ġȯ �� �� ���� 0�� ����
	public static String zero(int num) {

		String temp = Integer.toBinaryString(num);
		int length = temp.length();
		
		for(int i = 0 ; i < m + 1 - length; i++) {
			temp = 0 + temp;
		}
		temp += 0;
		return temp;

	}

	
	//�ش� �ڵ����̽��� ��밡���� ���� ���� �ڵ����̽� ã��
	
	

}




















