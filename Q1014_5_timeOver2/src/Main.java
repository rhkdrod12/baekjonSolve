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
	
	// Ǯ��
	public static void solve() {      
		
		codeCases = (int)Math.pow(2, m);
		dp = new int[n][codeCases];
		
		
		int result = 0;
		//���� ��� ����� ���� �Ź� �Ǵ��ع����� ������ �ð� �ʰ��� ���°� ������ 
		//�׷��� �ǰڳ� ��ġ�� ���� 001101010101011 �̷���?
		//String�� :���� �з��Ͽ� ���ø��� ����ϴ°� ��������..
		
		
		//dp[0] �Է�
		for(int i = 0 ; i < codeCases ; i ++) {
			
			String code = zero(i);
			int num = codeCompare(code, sit[0]);
			dp[0][i] = num;
			
			if(result < num) result = num;
		}
		
		//dp[1] �̻� �Է�
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
	
	//������ ��쿡 ��밡���� ���� ����� ���� ���ϱ�
	public static String CodeDecision(int codeCase) {
		String code = zero(codeCase);
		
		for(int i = 0 ; i < codeCases ; i++) {
			
		}
		
		
		return null;
	}
	
	// ���ڸ� 0�� 1�� ġȯ
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
	public static String zero(int str) {

		String temp = Integer.toBinaryString(str);
		int length = temp.length();
		
		for(int i = 0 ; i < m + 1 - length; i++) {
			temp = 0 + temp;
		}
		temp += 0;
		return temp;

	}
	
	//�ش� �ڵ����̽��� ��밡���� ���� ���� �ڵ����̽� ã��
	public static int[] caseConditon(String codeCase) {
		
		int temp[] = new int[codeCases];
		
		for(int i = 0 ; i < codeCases ; i++) {
			if(preCondition(codeCase, i)) {
				temp[i] = i;
			}
		}
		
		return temp;
	}
	
	
	// �ش� �ڵ忡 �̾� ���� �� �ִ� ���� ������ ����� ��
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
	
	// ���� �ڵ忡�� ���� ������ ���� ������ ����� ������ ���� ū ��ġ ���� ã��
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
	
	// ��ġ���� ���� ��ġ ������ ����� ���� ���� �л��� ã��
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
	
	// �ڵ忡 ���� ��ġ �� ��ȯ
	public static int bitCount(String codeCase) {
		int num = 0;
		for(int i = 1 ; i <codeCase.length() -1 ; i++ ) {
			if(codeCase.charAt(i) == '1') num++;
		}
		return num;
	}
	
	

}




















