import java.util.HashMap;
import java.util.Map;

public class LC219 {

	public LC219() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var solution=new Solution219();
		int[] nums= {1,2,3,1,2,3};
		solution.containsNearbyDuplicate(nums, 2);

	}

}


class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    	for(var i=0;i<nums.length;i++) {
    		var idx=map.getOrDefault(nums[i], -1);
//    		System.out.println(i);
//    		System.out.println(idx);
//    		System.out.println('\n');
    		
    		if (idx!=-1&&i-idx<=k) {
				return true;
			}
    		
    		map.put(nums[i], i);
    	}

    	 
    	return false;
    }
}











