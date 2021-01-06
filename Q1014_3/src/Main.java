import java.util.Scanner;


public class Main {

	static int t;
	static int n, m;
	
	static String sit[];   

	static int dp[][];
	static int cases;
	

	public static void main(String[] args) {
		/*
		 * t : �׽�Ʈ���̽�
		 * n : ���α���
		 * m : ���α���
		 * . : ���� �� �ִ� �ڸ�
		 * x : ���� �� ���� �ڸ�
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
	
	// . , x �� 1 �Ǵ� 0 ���� ġȯ, �� ���� 0�� �߰� 
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
	// ���� �Է¹޾� �ڸ��� ���߾� 0�� ���� �� �� ���� 0�� ����
	public static String zero(String str) {

		String temp = str;

		for(int i = 0 ; i < m + 1 - str.length(); i++) {
			temp = 0 + temp;
		}
		temp += 0;
		return temp;

	}
	// ���ڸ� �Է¹޾� ��Ʈ�� ġȯ �� �� ���� 0�� ����
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
		
		//����� ��
		cases = (int)Math.pow(2, m);
		//�� ������ ���� ������ ����� �� ����
		String dpAble[] = new String[cases];
		//dp �� ������ ���� ������ ��쿡 ���� ��ġ������ �л��� ���� ��
		dp = new int[n][cases];
		
		int result = 0;
		//���� ������ ��ġ ������ ��츦 ã�� 
		//����� ���� code, ��ġ������ �ڸ��� layout���� ���
		//�ڵ�� layout �翷���� 0�� �ο��Ǿ� ����
		
		//ó������ ��ġ �����ϸ� ��� ��ġ ����
		//�� ����� ���� �����鼭 dp[0]�� ����
		for(int i = 0 ; i < cases ; i ++) {
			
			String code = zero(i);
			int num = codeCompare(code, sit[0]);
			dp[0][i] = num;
			
			if(result < num) result = num;
			System.out.printf("level: %4d  code: %s  layout: %s  num: %4d  result: %4d\n", i, code, sit[0], num, result);
		}
		
		//n>0 �϶� dp[n] ��  dp[n-1]�� ����ؾ���
		for(int dpNum = 1 ; dpNum < n ; dpNum++) {
			for(int i = 0 ; i < cases ; i++) {
				
				String code = zero(i);
				int num = codeCompare(code, sit[dpNum]);
				int preNum = preCompare(code, dpNum);
				dp[dpNum][i] = num + preNum;
				
				//�ش� code�� ���� ������ ����� ������ ��밡���� ��츦 ã�� ���� ���� ū ��츦 ��ȯ�ϰ�
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
			//target�� 1�� ��쿡
			if(code.charAt(i) == '1') {
				//�� ������ 0�� ������ Ȯ��
				if(code.charAt(i+1) == '1' || layout.charAt(i) == '0') {
					return 0;
				}
				num++;
			}
		}
		return num;
	}
	

}




















