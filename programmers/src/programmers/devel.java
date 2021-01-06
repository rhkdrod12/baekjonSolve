package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class devel {
	public static void main(String[] args) {

		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		new DevSolution().solution(progresses, speeds);
		
		
	}
	}

class DevSolution{
	public int[] solution(int[] progresses, int[] speeds) {
		int length = progresses.length;
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int i = 0;
		
		while(i < length) {
			int count = 0;
			while(progresses[i] < 100) {
				for(int j = i ; j < length; j++) {
					progresses[j]+=speeds[j];
				}
			}
			while(i < length && progresses[i]>=100) {
				count++;
				i++;
			}
			ans.add(count);
		}
		
		int[] answer = new int[ans.size()];
		for(int j = 0 ; j < ans.size() ; j++) {
			answer[j] = ans.get(j);
		}
		
		return answer;
	}
}