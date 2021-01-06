package programmers;


public class Truck {
	public static void main(String[] args) {
		int length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};

		new TruckSolution().solution(length, weight, truck_weights);

	}
}
class TruckSolution{


	public int solution(int bridge_length, int weight, int[] truck_weights) {

		int answer = 1;
		int truckCnt = truck_weights.length;
		int truckTotal = truck_weights[0] ;

		//���°�����
		int[] state = new int[truckCnt];

		int sIdx = 0, eIdx = 1;

		while(sIdx < truckCnt){
			answer++;
			
			for(int i = sIdx ; i < eIdx ; i++) {
				state[i]++;
				if(state[i] == bridge_length) {
					sIdx++;
					truckTotal-=truck_weights[i];
				}
			}
			
			//Ʈ���� �ٸ��� ���� �� �ִ��� Ȯ���ϱ�
			if(eIdx < truckCnt && truckTotal + truck_weights[eIdx] <= weight ) {
				truckTotal+=truck_weights[eIdx];
				eIdx++;
			}
			
			System.out.printf("sIdx: %d eIdx: %d Ʈ������: %d ans: %d\n", sIdx, eIdx, truckTotal,answer);
		}

		return answer;
	}


}