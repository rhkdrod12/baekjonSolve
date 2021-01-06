package Q1005.acmfialed;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Acm {

	static int t, n, k;
	
	
	public static void main(String[] args) {
		
		int t, n, k;
		int x, y, w;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[입력]");
				
		t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
						
			n = sc.nextInt();
			k = sc.nextInt();
			
			System.out.printf("n, k입력완료 n: %d k: %d\n", n, k);
			
			Buliding node[] = new Buliding[n];
						
			for(int j = 0; j  < n ; j++) {
				node[j] = new Buliding();
				node[j].time = sc.nextInt();
				System.out.printf("[%d]:  %d",j , node[j].time);
			}
			System.out.println("");
			
			
			for(int j = 0; j < k ; j++) {
				
				x = sc.nextInt();
				y = sc.nextInt();				
				
				node[y-1].preBulid.add(node[x-1]);
				node[x-1].lastBulid.add(node[y-1]);
				
			}			
			
			System.out.println("건설경로 입력완료");
		
			int tempTime = 0;
			int target = sc.nextInt() - 1;
						
			node[0].sumTime =  node[0].time; 			
			Buliding tempBulid = node[0];
			
			System.out.println("연산시작");
			
							
			System.out.println("연산완료");
			int tempTime2 = 0;
			for(Buliding nod : node[target].preBulid)
			{
				if(tempTime2 < nod.sumTime) {
					tempTime2 = nod.sumTime;
				}
			}
			
			tempTime2 += node[target].time;
			
			
			System.out.println("test: " + tempTime2);
			
		}
		
		sc.close();
		
	}
	
	void Cal(Buliding node) {		
		
		Buliding temp;
		
		for(Buliding nod :node.lastBulid) {
			
		
		}
		
	}
	
}

class Buliding{	
	int time = 0;
	int sumTime = 0;
	ArrayList<Buliding> preBulid = new ArrayList<Buliding>();	
	ArrayList<Buliding> lastBulid = new ArrayList<Buliding>();	
}
