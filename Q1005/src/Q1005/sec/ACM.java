package Q1005.sec;

import java.util.ArrayList;
import java.util.Scanner;


public class ACM {

	static int t, n, k ,x, y, w;
	static Buliding nodes[];
	static ArrayList<Integer> processTime = new ArrayList<Integer>();
	
public static void main(String[] args) {
		
		input();
	
	}
	public static void input() {
		
		Scanner sc = new Scanner(System.in);
		
		t = 0;
		n = 0;
		k = 0;
		x = 0;
		y = 0;
		w = 0;
		nodes = null;
		
		System.out.println("[입력시작]");
		
		t= sc.nextInt();
		
		long startTime = System.nanoTime();
		
		
		for(int i = 0; i < t; i++) {
			
			n = sc.nextInt();
			k = sc.nextInt();
			
			
			nodes = new Buliding[n];
			
			for(int j = 0; j  < n ; j++) {
				
				nodes[j] = new Buliding();
				nodes[j].time = sc.nextInt();
			}
			System.out.println("");
			
			for(int j = 0; j < k ; j++) {
				
				x = sc.nextInt();
				y = sc.nextInt();				
				
				nodes[y-1].preBulid.add(nodes[x-1]);
				
			}
			
			
			w = sc.nextInt() - 1;
			
			
			int resultTime = calTime(nodes[w]);
			
			System.out.println("결과: " + resultTime);
		}
		
		System.out.println("전부입력완료");
		sc.close();
		
		long endTime = System.nanoTime();
		
		long estimatedTime = endTime - startTime;
		System.out.println("경과시간: " + (estimatedTime)*1e-9);
		
	}
	
	public static int calTime(Buliding targetNode) {
		
		// 어차피 역으로 돌리는게 경로상 가장 빠르게 계산할거 같네.
		// 처음부터 돌리면 하나둘씩 빠지는 놈들이 있을 거고
		
		
		int resultTime = targetNode.time;
		int tempTime = 0;
		
		if(!targetNode.preBulid.isEmpty()) {
			for(Buliding node : targetNode.preBulid) {
				
				int returnTime = calTime(node);				
				if(returnTime > tempTime) {
					tempTime = returnTime;
				}				
			}					
		}		
		return resultTime + tempTime;
	}
	
	
}

class Buliding{	
	
	int time = 0;
	int sumTime = 0;
	
	ArrayList<Buliding> preBulid = new ArrayList<Buliding>();	

	
}