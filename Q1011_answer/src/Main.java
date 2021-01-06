import java.util.Scanner;

public class Main {
	
	static int t, x, y;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
				
		t = sc.nextInt();
		
		while(t-- > 0) {
			x = sc.nextInt();
			y = sc.nextInt();
		
			solve();
		
		}
			
		sc.close();		
	}	
	
	static void solve() {
		
		int l = y - x;
		
		int count = 0;				
		double sqrtVal = Math.sqrt(l);		
		int intVal = (int)sqrtVal;
		
		if(Double.compare(sqrtVal, intVal) > 0)	
			count = 2*intVal;		
		else 
			count = 2*intVal - 1;
		
		if(l > intVal*intVal + intVal)
			count++;
			
		System.out.println(count);
		
	}
	
}
