import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static long[] num = new long[10];
	static int point;
	static ArrayList<Integer> numArr = new ArrayList<Integer>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int end = sc.nextInt();
		int start = 1;
		point = 1;
		
		sc.close();
		
		while(start <= end) {
			
			//end의 끝자리를 9로 만듬
			while(end%10 != 9 && start <= end) {
				revision(end, point);
				end--;
			}
			//만약 start가 더 커지면 종료, 어차피 위에서 보정한값들이 다 들어갔으니 보정완료
			if(start > end ) {
				break;
			}
			//start를 0으로 만들기
			while(start%10 != 0 && start <= end) {
				revision(start, point);
				start++;
			}
			//1의 자리를 제외한 값 구하기
			start/=10;
			end/=10;
			
			//0의 자리수 값 넣기
			for(int i = 0 ; i<=9 ; i++) {
				num[i] += (end - start +1)*point;
			}
			point *= 10;
		}
		
//		for(int i = 0 ; i < num.length ; i++) {
//			System.out.printf("%2d ", i);
//		}
//		System.out.println();
		for(int i = 0 ; i < num.length ; i++) {
			System.out.printf("%d ", num[i]);
		}
	}

	static void revision(int N, int point) {

		while(N > 0) {
			num[N%10]+=point;
			N/=10;
		}
	}


}
