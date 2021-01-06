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
		//  ��û�ð����� �ɸ��� �ð���
		//  ��û���� ������� �ɸ� �ð� : ����ð�(finExec) + �۾��ð�(jobs[][1])- ��û�ð�(jobs[][0])
		//	����ð��� ��� ���ϴ����� ���� �����ǰڳ�
		//  ó���� �̹� ������ ������ ���� ��쿡 
		//  ���� ���� ���μ����� �������� ��û�� ������ ����ť�� �ְ� ���ٸ� �ٷ� ���� ���� ����
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