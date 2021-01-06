package programmersTest;


public class Level2 {
	public static void main(String[] args) {
		
		int[] arr = {2,6,8,14};
		
		System.out.println(new Solution().solution(arr));
	}
}


class Solution {
	
	public int solution(int[] arr) {
        int val = arr[0];
        
        for(int i = 1 ; i< arr.length ; i++) {
        	val = lcm(val, arr[i]);
        	
        }
        
        
        return val;
    }
    
    int gcd(int a, int b){
    	while(b!=0){
    		int r = a%b;
    		a= b;
    		b= r;
    	}
    	return a;
    }
    
    int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
    
}