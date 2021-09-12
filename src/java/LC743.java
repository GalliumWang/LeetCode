import java.lang.reflect.Array;
import java.util.Arrays;

public class LC743 {

	public LC743() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
    	int[][] sdm=new int[n][n];
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			if(i!=j) {
    				sdm[i][j]=Integer.MAX_VALUE;
    			}
    		}
    	}
    	
    	for(int i=0;i<times.length;i++) {
    		sdm[times[i][0]-1][times[i][1]-1]=times[i][2];    		
    	}
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			for(int t=0;t<n;t++) {
    				sdm[j][t]=Math.min(sdm[j][t], sdm[j][i]+sdm[i][t]);
    			}
    		}
    	}
    	
    	for(var i:sdm) {
    		System.out.println(Arrays.toString(i));
    	}
    	
    	int max=0;
    	
    	for(int i=0;i<n;i++) {
    		if(i!=k-1&&sdm[k-1][i]>max) {
    			max=sdm[k-1][i];
    		}
    	}
    	
    	if(max==Integer.MAX_VALUE) {
    		return -1;
    	}
    	else {
			return max;
		}
    }
}














