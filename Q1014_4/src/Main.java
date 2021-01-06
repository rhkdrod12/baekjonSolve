import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.ha.StickyFeature;


public class Main {

	static int t, n, m;
	
	static boolean[][]	sitMap;   
	static boolean[] aMap, bMap;
	
	static int odd, even;
	static int oddMax, evenMax;
	
	static ArrayList<Integer>[] aEdgeLines;
	static int[] connectEdgeLine;
	
	public static void main(String[] args) {
		solve();
	}
	public static void solve() {
		/*
		 * t : �׽�Ʈ���̽�
		 * n : ���α���
		 * m : ���α���
		 * . : ���� �� �ִ� �ڸ�
		 * x : ���� �� ���� �ڸ�
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		oddMax = (m/2+m%2)*n;
		evenMax = (m/2)*n;
		aEdgeLines = new ArrayList[oddMax];
		
		//�⺻�� ����
		sitMap = new boolean[n][];
		
		
		//��ġ ����, �Ұ��ɿ� ���� false, true�� �Է�
		for(int i = 0 ; i < n ; i++) {
			sitMap[i] = bitmasking(sc.next());
		}
		
		bipartiteMatching();
		
		sc.close();
	}
	public static void bipartiteMatching(){
		
		aMap = new boolean[oddMax];
		bMap = new boolean[evenMax];
		
		connectEdgeLine = new int[]{-1, 0 , 1 , - 1 + n , n, 1+n};
		
		//����ȣ�� ����
		odd = even = -1;
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(i%2 != 0) {
					odd++;
					aEdgeLines[odd] = new ArrayList<Integer>();
					aMap[odd] = sitMap[i][j];
				}
				else {
					even++;
					bMap[even] = sitMap[i][j];
				}
			}
		}
		
		// ��������
		for(int i = 0 ; i < oddMax ; i++) {
			if(aMap[i]) continue;
			for(int d = 0 ; d < 6 ; d++) {
				//���� ���� �ʿ���
				//aMap�� bMap�� �̾���̴� �۾� �ʿ� 
				//bMap�� �ε��� ��ȣ�� aEdgeLines�� �־���� 
				
				int bLineNumber = i + connectEdgeLine[d];
				int bLineCondition = i%n + connectEdgeLine[d];
				
				if(bLineCondition < 0 || bLineCondition >= evenMax || bMap[bLineNumber]) continue;
				aEdgeLines[i].add(bLineNumber);
			}
		}
		
		for(int i = 0 ; i <oddMax ; i++) {
			System.out.printf("aEdgeLines[%d]:", i);
			System.out.println(aEdgeLines[i].toString());
		}
		// ��������
		// a�� b�� ������ ���ʸ� ������ ������ ��, a�� ���εǴ� b�� ã�´ٰ� �ϸ�
		// i �� ��
		// j �� ��
		// ������ �����ϴ°�
		// ����� ��ǥ�� i, j��� �� �� 
		// i-1	j-1		i-1	j+1
		// i 	j-1		i	j+1
		// i+1	j-1		i+1	j+1
		// �� ���� ������ ����
		
		
	}
	
	public static boolean[] bitmasking(String str) {
		boolean[] temp = new boolean[m];
		
		for(int i = 0 ; i < m ; i++) {
			if(str.charAt(i) == 'x') temp[i] = true;
			else temp[i] = false;
		}
		return temp;
	}
		
	

}




















