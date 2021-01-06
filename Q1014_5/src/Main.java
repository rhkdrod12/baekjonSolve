import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.xml.internal.ws.api.ha.StickyFeature;


public class Main {

	static int t, n, m;
	static StringTokenizer st;
	
	static char[][] sitMap;
	static int[][] nodeMap;
	
	static int aNodeIdx;
	static int aNodeCnt;
	static int broken;
	static boolean[] visited;
	
	static int[] aBMatch, bBMatch;
	
	static ArrayList<Integer>[] aNodeConnect;
	
	static int[][] edgeLine = {{-1,-1}, {-1,1}, {0,-1}, {0,1}, {1,-1},{1,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			broken = 0;
			aNodeIdx = -1;
			aNodeCnt = (m/2 + m%2)*n;
			
			sitMap = new char[n][m];
			nodeMap = new int[n][m];
			
			aNodeConnect = new ArrayList[aNodeCnt];
			
			//홀수를 가로로 카운트, 노드 번호 입력, 박살난 책상 카운트
			for(int i = 0 ; i < n ; i++) {
				sitMap[i] = br.readLine().toCharArray();
				for(int j = 0 ; j < m ; j++) {
					if(sitMap[i][j] == 'x') broken++;
					if(j%2 == 0) aNodeIdx++;
					
					aNodeConnect[aNodeIdx] = new ArrayList<Integer>();
					nodeMap[i][j] = aNodeIdx;
				}
			}
			
			//debug print용
			for(int i = -1 ; i < n ; i++) {
				if(i == -1) {
					i++;
					System.out.println("[a][b][a][b]");
				}
				for(int j = 0 ; j < m ; j++) {
					System.out.printf("%2d ", nodeMap[i][j]);
				}
				System.out.println();
			}
			
			//edgeLine = {{-1,-1}, {0,-1}, {1,-1}, {-1,1},{0,1},{1,1}};
			//{{-1,-1}, {1,-1}, {0,-1}, {0,1}, {-1,1},{1,1}};
			//간선연결
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j+=2) {
					if(sitMap[i][j] != 'x') {
						for(int d = 0; d < edgeLine.length ; d++) {

							int ei = i + edgeLine[d][0];
							int ej = j + edgeLine[d][1];

							if(ei>=0 && ei<n && ej>=0 && ej < m && sitMap[ei][ej] != 'x') {
								aNodeConnect[nodeMap[i][j]].add(nodeMap[ei][ej]); 
							}						
						}
					}
				}
			}
			
			//debug print용
			for(int i = 0 ; i < aNodeCnt; i++) {
				System.out.printf("[%2d]: %s\n", i , aNodeConnect[i].toString());
			}
			
			int bmCnt = 0;
			
			aBMatch = new int[aNodeCnt];
			bBMatch = new int[aNodeCnt];
			
			Arrays.fill(aBMatch, -1);
			Arrays.fill(bBMatch, -1);
			
//			System.out.println(aNodeCnt +"  " +aNodeIdx);
			for(int i = 0 ; i < aNodeCnt ; i++) {
				visited = new boolean[aNodeCnt];
				if(bfs(i)) bmCnt++; 
			}
			
			for(int i = 0 ; i < aNodeCnt ; i++) {
				System.out.printf("a: %2d b: %2d\n", bBMatch[i], i);
			}
			
			int result = n*m - bmCnt - broken;
			
			System.out.printf("broken: %2d bmCnt: %2d result: %2d\n", broken, bmCnt, result);
		}
	}
	
	static boolean bfs(int num) {
		
		if(visited[num]) return false;
		visited[num] = true;
		
		for(int i = 0 ; i < aNodeConnect[num].size() ; i++) {
			int bNodeNum = aNodeConnect[num].get(i);
			
			if(bBMatch[bNodeNum] == -1 || bfs(bNodeNum)) {
				bBMatch[bNodeNum] = num;
				aBMatch[num] = bNodeNum; 
				
				return true;
			}
		}
		
		return false;
	}
}




















