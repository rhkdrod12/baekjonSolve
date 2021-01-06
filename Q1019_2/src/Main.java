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
			
			//end�� ���ڸ��� 9�� ����
			while(end%10 != 9 && start <= end) {
				revision(end, point);
				end--;
			}
			//���� start�� �� Ŀ���� ����, ������ ������ �����Ѱ����� �� ������ �����Ϸ�
			if(start > end ) {
				break;
			}
			//start�� 0���� �����
			while(start%10 != 0 && start <= end) {
				revision(start, point);
				start++;
			}
			//1�� �ڸ��� ������ �� ���ϱ�
			start/=10;
			end/=10;
			
			//0�� �ڸ��� �� �ֱ�
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
