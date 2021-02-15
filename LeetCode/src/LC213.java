import java.util.Arrays;

public class LC213 {

	public LC213() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution213 {
	public int rob(int[] nums) {
		if(nums.length==3) {
			var tmpMax=nums[0]>nums[1]?nums[0]:nums[1];
			tmpMax=tmpMax>nums[2]?tmpMax:nums[2];
			return tmpMax;
		}
		else if (nums.length==2) {
			return nums[0]>nums[1]?nums[0]:nums[1];
		}
		else if (nums.length==1) {
			return nums[0];
		}
		else if (nums.length==0) {
			return 0;
		}
		
		//last element included
		int situation1=nums[nums.length-1];
		var subArray1=Arrays.copyOfRange(nums, 1, nums.length-2);
		situation1+=preRob(subArray1);
		
		//last element not included
		int situation2=0;
		var subArray2=Arrays.copyOfRange(nums, 0, nums.length-1);
		situation2+=preRob(subArray2);    	   
		
	    return situation1>situation2?situation1:situation2;
	}
	
	public int preRob(int[] nums) {
	    if (nums.length == 0) return 0;
	    int prev1 = 0;
	    int prev2 = 0;
	    for (int num : nums) {
	        int tmp = prev1;
	        prev1 = Math.max(prev2 + num, prev1);
	        prev2 = tmp;
	    }
	    return prev1;
	}
}