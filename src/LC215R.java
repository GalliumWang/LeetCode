import java.util.Random;

public class LC215R {

	public LC215R() {
		// TODO Auto-generated constructor stub
	}

}


class Solution215 {
	public int findKthLargest(int[] nums, int k) {
		// do some shuffle to boost perf

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        
        //select a[lo] as pivot
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        
        return j;
    }
    
    private int partition_simple_but_less_efficient(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= pivot) {
                exch(nums, i, j);
                i++;
            }
        }
        exch(nums, i, hi);
        return i;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    private boolean less(int v, int w) {
        return v < w;
    }
    
    /**
     * for shuffle array
     */    
    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
    
    
    
}


















