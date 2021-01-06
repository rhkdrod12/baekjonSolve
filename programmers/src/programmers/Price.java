package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Price {
	public static void main(String[] args) {
		
		int[] prices = new int[] {1, 2, 3, 2, 3};
		
		new Solution().solution(prices);
	}
}

class Solution {
    public int[] solution(int[] prices) {
        
        
        int[] ans = new int[prices.length];
        
        for(int i = 0 ; i < prices.length - 1 ; i++) {
        	for(int j = i+1 ; j < prices.length ; j++) {
        		ans[i]++;
        		if(prices[i] > prices[j]) break;
        	
        	}
        }
        
        return ans;
    }
}