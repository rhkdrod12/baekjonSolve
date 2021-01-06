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
		
		oddMax = (m/2+m%2)*n;
		evenMax = (m/2)*n;
		aEdgeLines = new ArrayList[oddMax];
		
		//기본값 셋팅
		sitMap = new boolean[n][];
		
		
		//배치 가능, 불가능에 따라 false, true로 입력
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
		
		//노드번호로 변경
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
		
		// 간선매핑
		for(int i = 0 ; i < oddMax ; i++) {
			if(aMap[i]) continue;
			for(int d = 0 ; d < 6 ; d++) {
				//아직 수정 필요함
				//aMap과 bMap을 이어붙이는 작업 필요 
				//bMap의 인덱스 번호를 aEdgeLines에 넣어야함 
				
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
		// 간선매핑
		// a나 b나 연결은 한쪽만 가지고 있으면 됨, a에 매핑되는 b를 찾는다고 하면
		// i 는 열
		// j 는 행
		// 간선을 형성하는건
		// 노드의 좌표가 i, j라고 할 때 
		// i-1	j-1		i-1	j+1
		// i 	j-1		i	j+1
		// i+1	j-1		i+1	j+1
		// 의 간선 구조를 가짐
		
		
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




















