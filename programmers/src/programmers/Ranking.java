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
		 * ��Ȯ�� ������ ���� �� �ִ� ����� ���� ã�� ���� ������ ��ȯ�϶�� ������ �ƴ�
		 * 
		 * �׷� ������ �� �� �ִ� ������� �ش� ��忡 ���� ������ �־�� �� �� �ִ� �Ű��� ����� ������ n-1��ŭ ����Ǿ������� ������ �� ��
		 * ����
		 * 
		 * �׷��� ��.. �ش� ��尡 �й��� ���� -1�� ����Ǿ��ְ� �̱� ���� 1�� ����Ǿ�����
		 * 
		 * 1�� ��� ���ο��� 
		 * 
		 */

		return answer;
	}

	public int search(int target, int val, int[][] list, boolean[] visited, int edgeCnt) {

		
		
		
		return 0;
	}

}