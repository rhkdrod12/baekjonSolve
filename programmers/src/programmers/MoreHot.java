package programmers;

import java.util.PriorityQueue;

public class MoreHot {
	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;

		new MoreHotSolution().solution(scoville, K);
	}
}

class MoreHotSolution{

	public int solution(int[] scoville, int K) {

		int answer = 0;

		PriorityQueue<Integer> qu = new PriorityQueue<Integer>();

		for(int i = 0 ; i < scoville.length; i++) {
			qu.add(scoville[i]);
		}
		
		int fst, sec, temp;

		while(!qu.isEmpty() && qu.peek() < K) {
			fst = qu.poll();

			if(qu.isEmpty() && fst < K) {
				return -1;
			}
			
			sec = qu.poll();

			temp = fst + sec*2;
			answer++;
			qu.add(temp);
		}
		System.out.println(answer);
		return answer;
	}
}