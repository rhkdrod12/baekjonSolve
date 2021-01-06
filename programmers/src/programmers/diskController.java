package programmers;

import java.util.PriorityQueue;

public class diskController {
	public static void main(String[] args) {

		int jobs[][] = {{0,3},{1,9},{2,6}};
		
		System.out.println(new diskCtlSoultion().solution(jobs));
	}
}

class diskCtlSoultion{
	public int solution(int[][] jobs) {

		PriorityQueue<int[]> readyQueue = new PriorityQueue<int[]>((a,b)->((a[1] - a[0]) - (b[1] - b[0])));
		PriorityQueue<int[]> waitQueue = new PriorityQueue<int[]>((a,b)->(a[0] - b[0]));

		//	{{0,3},{4,9},{6,6}};
		//  요청시간부터 걸리는 시간은
		//  요청부터 종료까지 걸린 시간 : 진행시간(finExec) + 작업시간(jobs[][1])- 요청시간(jobs[][0])
		//	진행시간을 어떻게 구하는지에 따라 걸졍되겠네
		//  처음은 이미 진행한 것으로 봤을 경우에 
		//  진행 중이 프로세스가 종료전에 요청이 있으면 래디큐에 넣고 없다면 바로 다음 것을 실행
		//	[[0, 3], [4, 3], [8, 3]] 3
		//	[[0, 5], [6, 1], [6, 2]] 3
		//	[[0, 5], [6, 2], [6, 1]] 3
		//	[[0, 5], [2, 2], [5, 3]] 5
		//	[[0, 5], [2, 2], [4, 2]] 5
			
		for(int i = 0 ; i < jobs.length; i++) {
			waitQueue.add(jobs[i]);
		}
		
		int answer =  0;
		int finExec = waitQueue.peek()[0];
		int cnt = 0;
		int size = jobs.length;
		
		while(cnt < size) {
			
			while(!waitQueue.isEmpty() &&  waitQueue.peek()[0] <= finExec){
				readyQueue.offer(waitQueue.poll());
			}
			
			if(!readyQueue.isEmpty()) {
				int[] temp = readyQueue.poll();
				finExec += temp[1];
				answer += finExec - temp[0];
				cnt++;
			}
			else {
				finExec++;
			}
		}
		
//		System.out.println(answer);
		return answer/size;
	}


}
