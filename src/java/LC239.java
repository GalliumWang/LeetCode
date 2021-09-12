import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC239 {

	public LC239() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}


/**
 * 
 * in every state of the sub array,find the index of peak,
 * when sub array slide over that peak,find the next peak
 *
 */

class Solution239 {
	
	private int get_idx_of_max(int[] nums,int start,int end) {
		int max_num=nums[start];
		int max_idx=start;
		
		for(var i=start;i<end;i++) {
			if(nums[i]>=max_num) {
				max_num=nums[i];
				max_idx=i;
			}
		}
		
		return max_idx;
	}
	
    public int[] maxSlidingWindow(int[] nums, int k) {
    	
    	
    	int length=nums.length;
    	
    	int start=0;
    	int end=k;
    	
    	int iteration=length-k;
    	int[] res=new int[iteration+1];
    	
    	
    	int peak_idx=get_idx_of_max(nums, start, end-1);
    	
//    	int current_edge=end-2;
    	
    	for(var i=0;i<=iteration;i++) {
    		int temp_start=i;
    		int temp_end=i+k;
    		if(peak_idx>=temp_start) {
    			peak_idx=nums[temp_end-1]>=nums[peak_idx]?temp_end-1:peak_idx;
    		}
    		else {
    			peak_idx=get_idx_of_max(nums, temp_start, temp_end);
    		}
    		
    		System.out.println(peak_idx);
    		
    		res[i]=nums[peak_idx];
    	}
    	
    	
    	
    	return res;
    }
}

class Solution239_TLE {
	private int get_max(int[] ary) {
		return Arrays.stream(ary).max().getAsInt();
	}
	
    public int[] maxSlidingWindow(int[] nums, int k) {
    	int length=nums.length;
    	int idxFrom=0;
    	int idxTo=length-k;
    	List<Integer> res=new ArrayList<Integer>();
    	
    	for(int i=idxFrom;i<=idxTo;i++) {
    		res.add(get_max(Arrays.copyOfRange(nums, i, i + k)));
    	}
    	
        int[] ret = new int[res.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = res.get(i).intValue();
        }
        return ret;
    }
}















