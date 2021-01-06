package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Ranking {
	public static void main(String[] args) {

		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

		System.out.println(new RankingSolution().solution2(n, results));

	}
}

class RankingSolution {

	public int solution2(int n, int[][] results) {

		int answer = 0;

		int[][] list = new int[n + 1][n + 1];

		for (int i = 0; i < results.length; i++) {
			list[results[i][0]][results[i][1]] = 1;
			list[results[i][1]][results[i][0]] = -1;
		}

		for (int i = 0; i < list.length; i++) {
			System.out.println(Arrays.toString(list[i]));
		}
		for (int i = 1; i <= n; i++) {
			boolean[] visited = new boolean[n + 1];

			visited[i] = true;
			
		}

//      for(int i = 0 ; i < )

		/*
		 * 정확히 순위를 정할 수 있는 경우의 수를 찾는 문제 순위를 반환하라는 문제가 아님
		 * 
		 * 그럼 순위를 알 수 있는 방법에는 해당 노드에 전부 연결이 있어야 알 수 있는 거겠지 노드의 연결이 n-1만큼 연결되어있으면 순위를 알 수
		 * 있음
		 * 
		 * 그러면 흠.. 해당 노드가 패배한 노드는 -1로 연결되어있고 이긴 노드는 1로 연결되어있음
		 * 
		 * 1인 노드 라인에는 
		 * 
		 */

		return answer;
	}

	public int search(int target, int val, int[][] list, boolean[] visited, int edgeCnt) {

		
		
		
		return 0;
	}

}