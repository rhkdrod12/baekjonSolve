package Q1002.terret;

import java.util.Scanner;


public class Terret {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("테스트 케이스 수 입력: ");
		int testCase = sc.nextInt();
		
		int x1 = 0;
		int y1 = 0;			
		int r1 = 0;
		
		int x2 = 0;
		int y2 = 0;
		int r2 = 0;
		
		int count[] = {0, 0, 0};
		
		for(int i = 0; i < testCase ; i++) {
			
			boolean flag = false;
			
			while(flag == false) {
				
				System.out.print("x1, y1, r1, x2, y2, r2 입력: ");
				
				x1 = sc.nextInt();
				y1 = sc.nextInt();			
				r1 = sc.nextInt();
				
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				r2 = sc.nextInt();
							
				if(compareValue(x1, -10000, 10000) &&
				compareValue(y1, -10000, 10000) &&
				compareValue(x2, -10000, 10000) &&
				compareValue(y2, -10000, 10000) &&
				compareValue(r1, 1, 10000) &&
				compareValue(r2, 1, 10000)) 
				{
					break;					
				}
				System.out.println("잘못된 범위 입력!, 다시 입력!");			
			}			
			
			/*
			 * 두 좌표가 서로 만날 수 있는 경우 -> 좌표에서 사거리만큼 원으로 그렸을 때 그 원이 서로 만나는 경우만 해당
			 * 경우의 수는 한 점으로 만날 경우, 두 점으로 만날 경우, 겹치는 경우, 안만나는 경우 4가지로 분류 됨
			 * 
			 * 한 점의 경우 : 만나는 수는 1
			 * 두 점의 경우 : 만나는 수는 2
			 * 겹치는 경우 : 무한대
			 * 안만나는 경우: 0
			 * 
			 * 두 좌표간의 거리를 d라고 했을 때 
			 * 
			 * 서로 밖에서 안 만나는 경우							: d>0, r1+r2 < d
			 * 외접형태로 두 원이 서로 한 점에서 만날 때 					: d>0, r1+r2 = d 			
			 * 두 점에서 만나는 경우 								: d>0, r1-r2 < d < r1+r2 			  
			 * 내접형태로 두 원이 서로 한 점에서 만날 때(r1 > r2 인 경우)	: d>0, r1-r2 = d	
			 * 서로 안에서 안 만나는 경우							: d>=0, r1-r2 > d
			 * 겹치는 경우 										: d = 0, r1-r2 = 0 (r1 = d = r2)
			 * 
			 */
			
			
			double d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));						
			
			if(r1 < r2) {
				int temp = r2;
				r2 = r1;
				r1 = temp;
			}			
			
			int min = r1 - r2;
			int max = r1 + r2;			
			
			if(compareValue(d, 0) == 1) {				
															//서로 밖에서 만나는 경우 (생략)
				
				if(compareValue(d, max) == 0) {				//서로 외접하는 경우
					count[i] = 1;
				}
				else if(compareValue(d, max) == -1){		//서로 안에서 만나는 경우						
					if(compareValue(d, min) == 1) {			//안에서 만나는데 두 점으로 만나는 경우
						count[i] = 2;
					}
					else if(compareValue(d, min) == 0) {	//안에서 만나는데 한 점에서 만나는 경우
						count[i] = 1;
					}					
					// 										//서로 안에서 안만나는 경우(생략)
				}				
			}
			else {
															//서로 안에서 안만나는 경우2(생략)				
				if(compareValue(d, min) == 0){				//서로 겹치는 경우
					count[i] = -1;
				}
			}				
			System.out.println("겹치는 좌표 수: "+count[i]);			
		}			
		sc.close();
	}
	
	private static boolean compareValue(int value, int start, int end) {
		
		if(value >= start && value <= end) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	private static int compareValue(double value, double value2) {
		return Double.compare(value, value2);		
	}
}
