package programmers;

import java.util.Arrays;

public class Hindex {
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		
		new HIndexSolution().solution(citations);
	}
}

class HIndexSolution{
	public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        
        System.out.println(Arrays.toString(citations));
        
        return answer;
    }
}