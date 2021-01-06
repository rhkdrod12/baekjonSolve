package ssser;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ACM.input();
	}

}


class ACM {
	
	static int t, n, k ,x, y, w;
	static Buliding nodes[];
	static ArrayList<Integer> processTime = new ArrayList<Integer>();
		
	public static void input() {
		
		Scanner sc = new Scanner(System.in);
			
		t= sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			
			nodes = null;
			
			n = sc.nextInt();
			k = sc.nextInt();
						
			nodes = new Buliding[n];
			
			for(int j = 0; j  < n ; j++) {				
				nodes[j] = new Buliding();
				nodes[j].time = sc.nextInt();
			}		
			
			for(int j = 0; j < k ; j++) {				
				x = sc.nextInt();
				y = sc.nextInt();								
				nodes[y-1].preBulid.add(nodes[x-1]);				
			}	
			
			w = sc.nextInt() - 1;	
			
			System.out.println(calTime(nodes[w]));
		}
		sc.close();
	}

	public static int calTime(Buliding targetNode) {
		
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
	ArrayList<Buliding> preBulid = new ArrayList<Buliding>();	
}