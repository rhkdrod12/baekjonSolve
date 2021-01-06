package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class printer {
	public static void main(String[] args) {
		//		int[] priorities = {2,1,3,2};
		//		int location = 2;

		int[] priorities = {1,1,9,1,1,1};
		int location = 0;

		new PrinterSolution().solution(priorities, location);
	}
}

class PrinterSolution{

	public int solution2(int[] priorities, int location) {
		int answer = 0;
		int size = priorities.length;
		int idx = priorities.length-1;


		Queue<Integer> qu = new LinkedList<Integer>();

		for(int i = 0 ; i <size ; i++) {
			qu.add(priorities[i]);
		}
		Arrays.sort(priorities);

		while(true) {

			int temp = qu.poll();
			location--;

			if(temp != priorities[idx]) {
				qu.add(temp);
				if(location == -1) location = qu.size()-1;
			}
			else {
				answer++;
				idx--;
				if(location == -1) break;
			}
			if(qu.isEmpty()) break;
		}
		return answer;
	}

	public int solution(int[] priorities, int location) {
		int answer = 0;
		int size = priorities.length;
		int idx = 0;

		System.out.println(Arrays.toString(priorities));
		Integer[] sortPriorities = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
		Arrays.sort(sortPriorities,Comparator.reverseOrder());

		System.out.println(Arrays.toString(sortPriorities));
		Queue<Integer> qu = new LinkedList<Integer>();


		for(int i = 0 ; i <size ; i++) {
			qu.add(priorities[i]);
		}

		while(true) {

			int temp = qu.poll();
			location--;

			if(temp != sortPriorities[idx]) {
				qu.add(temp);
				if(location == -1) location = qu.size()-1;
				System.out.printf("temp: %d location: %2d ", temp, location);
				System.out.printf("Qsize: %d %s ", qu.size(), qu.toString());
			}
			else {
				System.out.printf("temp: %d location: %2d ", temp, location);
				System.out.printf("Qsize: %d %s ", qu.size(), qu.toString());
				answer++;
				idx++;
				System.out.print("v");
				if(location == -1) break;
			}
			System.out.println();

			if(qu.isEmpty()) break;
		}
		System.out.println();
		System.out.println(answer);
		return answer;
	}


}