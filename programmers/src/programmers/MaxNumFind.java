package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNumFind {
	public static void main(String[] args) {
		
		int[] numbers = {6, 10, 2};
		int[] numbers2 = {3, 30, 34, 3334, 0};
		int[] numbers3 = {0,0,0,0,0};
		new MaxFindSolution().solution(numbers3);
		
		
	}
}

class MaxFindSolution{
	
	public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        for(int i = 0 ; i < nums.length; i++) {
        	nums[i] = String.valueOf(numbers[i]);
        }
        
        Comparator<String> comp = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				
				int tmp1 = Integer.parseInt(o1+o2);
				int tmp2 = Integer.parseInt(o2+o1);
				
				if(tmp1 > tmp2) return -1;
				else if(tmp1 < tmp2) return 1;
				return 0;
			}
		};        

		Arrays.sort(nums, comp);
		
		if(nums[0].contains("0")) return "0";
		
		for(int i = 0 ; i < nums.length; i++) {
			answer+=nums[i];
		}
		System.out.println(answer);
        return answer;
       
    }
	
}