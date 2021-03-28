import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC260 {

	public LC260() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution260 {
    public int[] singleNumber(int[] nums) {
    	Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
        	if(set.contains(nums[i])) {
        		set.remove(nums[i]);
        	}
        	else {
				set.add(nums[i]);
			}
        }
        
        System.out.println(set);
        int[] res=new int[set.size()];
        
        int idx=0;
        for(var i:set) {
        	res[idx]=i;
        	idx++;
        }
        
        return res;
    }
}


class Solution_linear_time {
    public int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}



















