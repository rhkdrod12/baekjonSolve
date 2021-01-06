package Q1004.pcs;

import java.util.Scanner;

public class Pcs {
	
	
	
	public static void main(String[] args) {
		
		int x1;
		int y1;
		
		int x2;
		int y2;
		
		int cx[];
		int cy[];
		int cr[];
		
		int n;
		
		/*
		 * 점 				d1 , d2
		 * 경로상				n1, n2, n3, n4 
		 * 각각의 반지름 		r1, r2, r3, r4
		 * 
		 * d1에 대한 경로거리	c1, c2, c3, c4
		 * d2에 대한 경로거리	v1, v2, v3, v4
		 * 
		 * n1에서만 봤을 때
		 * 
		 * c1 < r1 , v1 < r1	:	d1 < n1 , d2 < n2	->	진입/이탈 = 0
		 * c1 < r1 , c1 > r1	:	d1 < n1 , d2 > n2	->	진입/이탈 = 1
		 * c1 > r1 , c1 < r1	:	d1 > n1 , d2 < n2	->	진입/이탈 = 1
		 * c1 > r1 , c1 > r1	:	d1 > n1 , d2 > n2	-> 	진입/이탈 = 0
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("테스트 케이스 수: ");
		int testCase = sc.nextInt();
		
		for(int test = 0 ; test < testCase ; test++) {
			
			int count = 0;
			boolean f1, f2;
			
//			System.out.print("x1, y1, x2, y2: ");
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			
//			System.out.print("n: ");
			n = sc.nextInt();
			
			cx = new int[n];
			cy = new int[n];
			cr = new int[n];
			
			for(int lo = 0; lo < n ; lo++) {
				
//				System.out.printf("[%d번] cx, cy, cr: ", lo);
				cx[lo] = sc.nextInt();
				cy[lo] = sc.nextInt();
				cr[lo] = sc.nextInt();
//				System.out.println("");
				
			}
					
			for(int i = 0 ; i < n ; i++) {
				f1 = Math.pow((x1-cx[i]), 2) + Math.pow((y1-cy[i]), 2) > Math.pow(cr[i], 2) ? true : false;
				f2 = Math.pow((x2-cx[i]), 2) + Math.pow((y2-cy[i]), 2) > Math.pow(cr[i], 2) ? true : false;
				
				if(f1^f2) {
					count++;
				}				
			}
			
			System.out.println("진입/이탈 수: "+count);
		}
		
		
		sc.close();
		
		
		
		
	}
	
	
	
	
	
	
}
