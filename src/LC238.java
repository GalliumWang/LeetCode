
public class LC238 {

	public LC238() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

/**
 * 
 * use a two dimension array below
 * 
 * 0 1 . . . 1
 * 1 0 . . . 1
 * 1 1 . . . 1
 * . . . . . . 
 * 1 1 . . . 0
 * 
 * [the array above is just for concept and can be avoid in code]
 * 
 * to multiply the res array of [1 1 . . . . 1]
 *
 */

class Solution238_space {
    public int[] productExceptSelf(int[] nums) {
        
    	
    	return null;
    }
}

/**
 * 
 * use below formula:
 * d((a+b)c+ab)+abc
 * use this in an array
 *
 * !!! time complexity exceed
 */

class Solution238_time {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}


















