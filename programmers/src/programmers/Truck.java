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

		//상태값저장
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
			
			//트럭을 다리에 넣을 수 있는지 확인하기
			if(eIdx < truckCnt && truckTotal + truck_weights[eIdx] <= weight ) {
				truckTotal+=truck_weights[eIdx];
				eIdx++;
			}
			
			System.out.printf("sIdx: %d eIdx: %d 트럭무게: %d ans: %d\n", sIdx, eIdx, truckTotal,answer);
		}

		return answer;
	}


}