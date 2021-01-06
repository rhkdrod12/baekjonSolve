import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long min = sc.nextLong();
		long max = sc.nextLong();

		sc.close();
		int range = (int)(max-min+1);
		
		boolean[] visited = new boolean[range];
		
		int ans = range;
		long jump = 3;
		int step = 2;
		int count = 0;

		for(long j = jump ; j <= max; j+=(jump+=step)) {
			
			long r = j+1;
			long start =  min%r == 0? min:(min/r)*r+r;
			
			for(long i = start ; i <=max; i+=r) {
				int idx = (int)(i - min);
				if(!visited[idx]) {
					visited[idx] =true;
					count++;
				}
				
			}
		}
		System.out.println(ans-count);
	}   
}


















