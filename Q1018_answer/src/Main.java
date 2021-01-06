import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		char[][] arr = new char[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int wCnt;
		int bCnt;
		//다음 줄에서는 이게 서로 뒤바뀌어야한단 말이지.
		
		int wTotalCnt = 0;
		int bTotalCnt = 0;
		
		int ans = 0;
		
		//i y축 j가 x축
		for(int e = 0 ; e < N - 7 ; e++) {
			for(int k = 0 ; k < M - 7 ; k++) {
				wTotalCnt = bTotalCnt = 0;
				for(int i = e ; i < e + 8 ; i++) {
					wCnt = bCnt = 0;
					for(int j = k ; j < k + 7 ; j+=2) {
						if(arr[i][j] == 'W') {
							wCnt++;
						}
						if(arr[i][j+1] == 'B') {
							wCnt++;
						}
						if(arr[i][j] == 'B') {
							bCnt++;
						}
						if(arr[i][j+1] == 'W') {
							bCnt++;
						}
					}
					if(i%2 != 0) {
						int temp = wCnt;
						wCnt = bCnt;
						bCnt = temp;
					}
					wTotalCnt += wCnt;
					bTotalCnt += bCnt;
				}
				ans = Math.max(ans, wTotalCnt);
				ans = Math.max(ans, bTotalCnt);
				
				
			}
		}
		System.out.println(8*8 - ans);
		
		
	}

}
