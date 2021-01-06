package programmers;

import java.util.PriorityQueue;

public class DoublePriority {

	public static void main(String[] args) {
//		String[] operations = {"I 16","D 1"};
		
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		new DoublePrioritySolution().solution(operations);
	}
}

class DoublePrioritySolution{

	public int[] solution(String[] operations) {
		
		int[] answer;
		
		PriorityQueue<Integer> dataMax = new PriorityQueue<Integer>((a,b)->b-a);
		PriorityQueue<Integer> dataMin = new PriorityQueue<Integer>();

		for(int i = 0 ; i < operations.length; i++) {
			
			String[] temp = operations[i].split(" ");
			
			if(temp[0].contains("I")) {
				int num = Integer.parseInt(temp[1]);
				dataMax.offer(num);
				dataMin.offer(num);
			}
			else {
				if(temp[1].contains("-1") && !dataMin.isEmpty()) {
					dataMax.remove(dataMin.poll());
				}
				else if(temp[1].contains("1")) {
					dataMin.remove(dataMax.poll());
				}
			}
		}
		
		if(dataMin.isEmpty()) answer = new int[] {0,0};
		else answer = new int[] {dataMax.poll(), dataMin.poll()};
		
		return answer;
	}

}