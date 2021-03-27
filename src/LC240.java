public class LC240 {

	public LC240() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution240_wrong {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        int stop_point=0;
        while(matrix[stop_point][stop_point]<target) {
        	stop_point++;
        }
        
        /**
         * check row
         */
        for(int i=0;i<=stop_point;i++) {
        	if(matrix[i][stop_point]==target) {
        		return true;
        	}
        }
        
        
        /**
         * check col
         */
        for(int i=0;i<stop_point;i++) {
        	if(matrix[stop_point][i]==target) {
        		return true;
        	}
        }   
        
    	return false;
    }
}


class Solution240 {
	int g_m;
	int g_n;
	private boolean out(int p_m,int p_n) {
		if(p_m>=g_m) {
			return true;
		}
		if(p_n<0) {
			return true;
		}
		return false;
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        g_m=m;
        g_n=n;
        
        int idx_r=0;
        int idx_c=n-1;
        
        while(true) {
        	if(matrix[idx_r][idx_c]==target) {
        		return true;
        	}
        	if (matrix[idx_r][idx_c]<target) {
				idx_r++;
			}
        	else {
				idx_c--;
			}
        	
        	if(out(idx_r,idx_c)) {
        		return false;
        	}
        	
        }

    }
}




















