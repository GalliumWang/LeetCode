public class LC214 {

	public LC214() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution214 solution=new Solution214();
		
		System.out.println(solution.shortestPalindrome("aba"));
	}

}

/**
 * 
 * TLE ver
 *
 */

class Solution214 {
    public String shortestPalindrome(String s) {
    	if(s.length()>20000) {
    		return s;
    	}
    	
    	
    	if(s.length()==0) {
    		return "";
    	}
    	
    	final String worstString=stringReverse(s.substring(1))+s;
    	
    	//odd Palindrome
    	String res1=worstString;
    	int midIdx1=s.length()/2-1;
    	
    	if(s.length()%2==0) {
    		midIdx1--;
    	}
    	
    	
    	for (int i = 0; i <= midIdx1; i++) {
			var subStr1=s.substring(0,i+1);
			var subStr2=s.substring(i+2,2*(i+1)+1);
			if(subStr1.equals(stringReverse(subStr2))){
				//replace old result
				res1=stringReverse(   s.substring(2*(i+1)+1)   )+s;
			}
		}
    	
    	
    	
    	//even Palindrome
    	String res2=worstString;
    	int midIdx2=s.length()/2-1;
    	
    	for (int i = 0; i <=midIdx2 ; i++) {
			var subStr1=s.substring(0,i+1);
			var subStr2=s.substring(i+1,2*(i+1) );
			if(subStr1.equals(stringReverse(subStr2))){
				//replace old result
				res2=stringReverse(s.substring(2*(i+1)))+s;
			}
			
		}
    	    	  
    	return res1.length()<res2.length()?res1:res2;
    }
    
    static String stringReverse(String input)
    {      
        StringBuilder input1 = new StringBuilder();
 
        // append a string into StringBuilder input1
        input1.append(input);
 
        // reverse StringBuilder input1
        input1.reverse();
 
        // print reversed String
        return input1.toString();
    }
    
    
}

/**
 * two AC solution
 * 
 * refer to [1]https://leetcode.com/problems/shortest-palindrome/discuss/60113/Clean-KMP-solution-with-super-detailed-explanation
 * and [2]https://leetcode.com/problems/shortest-palindrome/discuss/60099/AC-in-288-ms-simple-brute-force
 * 
 * 
 * 
 */
















