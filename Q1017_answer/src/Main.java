import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

	static boolean[] prime = new boolean[2001];

	static ArrayList<Integer> ans = new ArrayList<Integer>();

	static int[] arr;
	static ArrayList<Integer> arrA = new ArrayList<Integer>();
	static ArrayList<Integer> arrB = new ArrayList<Integer>();

	static ArrayList<Integer>[] aNode;
	static boolean visited[];
	static int[] aCntd;

	public static void main(String[] args) throws IOException {

		isPrime(prime);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(arr[i]%2 == 0) {
				arrB.add(arr[i]);
			}
			else {
				arrA.add(arr[i]);
			}
		}

		//배열 홀수 짝수 개수 확인
		if(arrB.size() == arrA.size()) {

			//배열 첫 값이 짝수인지 홀수인지 판단하여 스왑실행
			if(arr[0]%2 == 0) {
				ArrayList<Integer> temp = arrA;
				arrA = arrB;
				arrB = temp;
			}

			Collections.sort(arrB);

			aNode = new ArrayList[arrA.size()];

			int idxA = 0 , idxB;

			for(int numA : arrA) {
				aNode[idxA] = new ArrayList<Integer>();
				idxB = 0;
				for(int numB : arrB) {
					if(!prime[numA + numB]) {
						aNode[idxA].add(idxB);
					}
					idxB++;
				}
				idxA++;
			}

			int count;
			
			Integer[] zeroNum = aNode[0].toArray(new Integer[aNode[0].size()]);

			visited = new boolean[idxA];
			aCntd = new int[idxA];

			for(Integer num : zeroNum) {
				
				aNode[0].clear();
				aNode[0].add(num);

				Arrays.fill(aCntd, -1);

				count = 0;
				for(int i = 0 ; i < idxA ; i++) {
					Arrays.fill(visited, false);
					if(bfs(i)) count++;
				}
				
				if(count == (arr.length)/2) {
					ans.add(arrB.get(num));
				}
			}
		}

		if(ans.isEmpty())
			ans.add(-1);

		for(int num : ans) {
			System.out.print(num + " ");
		}

	}

	static boolean bfs(int num) {

		if(visited[num]) return false;
		visited[num] = true;

		for(int bNum : aNode[num]) {
			if(aCntd[bNum] == -1 || bfs(aCntd[bNum])) {
				aCntd[bNum] = num;
				return true;
			}
		}
		return false;
	}

	static void isPrime(boolean[] arr) {
		for(int i = 2 ; i*i < arr.length ; i++) {
			if(!arr[i]) {
				for(int j = i+i; j < arr.length ; j+=i) {
					arr[j] = true;
				}
			}
		}
	}

}
