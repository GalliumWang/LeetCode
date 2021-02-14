public class LC209 {

	public LC209() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rawArray= {1,2,3,4,5};
		new Solution().minSubArrayLen(15, rawArray);
	}

}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        Boolean solvable=false;
        int startIdx=0;
        int endIdx=0;
        for(var i=0;i<nums.length;i++) {
        	if(solvable) {
        		// when end num not included
        		var solutionLen=endIdx-startIdx;
        		
        		// when end num included
        		int endhold=i+1;
        		int tmpStartIdx=0;
        		int tmpEndIdx=0;
        		int tmpSum=0;
				for(var j=i;j>=0;j--) {
					tmpSum+=nums[j];
					if(tmpSum>=target) {
						tmpStartIdx=j;
						tmpEndIdx=endhold;
						break;
					}
				}
				int tmpSolutionLen=tmpEndIdx-tmpStartIdx;
				
				// compare
				if(tmpSolutionLen<=solutionLen) {
					startIdx=tmpStartIdx;
					endIdx=tmpEndIdx;
				}
				
				
        	}
        	else {	
        		//sum up from end
        		int endhold=i+1;
        		int tmpSum=0;
				for(var j=i;j>=0;j--) {					
					tmpSum+=nums[j];
					if(tmpSum>=target) {
						solvable=true;
						startIdx=j;
						endIdx=endhold;						
						break;
					}
				}
				
				
			}
        }
        
        if(!solvable) {
        	return 0;
        }
        else {        	
			return endIdx-startIdx;
		}
        
    }
    private int get_sum(int[] nums,int startIdx,int endIdx) {
    	int sum=0;
		for(var i = startIdx;i<endIdx;i++) {
			sum+=nums[i];
		}
		return sum;
	}
}