import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC239 {

	public LC239() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}


class Solution239 {
	private int get_max(int[] ary) {
		return Arrays.stream(ary).max().getAsInt();
	}
	
    public int[] maxSlidingWindow(int[] nums, int k) {
    	
    	
//    	int length=nums.length;
//    	int idxFrom=0;
//    	int idxTo=length-k;
//    	List<Integer> res=new ArrayList<Integer>();
//    	
//    	for(int i=idxFrom;i<=idxTo;i++) {
//    		res.add(get_max(Arrays.copyOfRange(nums, i, i + k)));
//    	}
//    	
//        int[] ret = new int[res.size()];
//        for (int i=0; i < ret.length; i++)
//        {
//            ret[i] = res.get(i).intValue();
//        }
//        return ret;
    }
}












