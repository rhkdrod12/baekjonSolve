package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Knumber {
	public static void main(String[] args) {

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		new KnumberSolution().solution(array, commands);
	}
}

class KnumberSolution{

	public int[] solution(int[] array, int[][] commands) {
		
		int[] answer = new int[commands.length];
		
		for(int i = 0 ; i < commands.length ; i++) {
			int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(tmp);
			answer[i] = tmp[commands[i][2]-1];
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}