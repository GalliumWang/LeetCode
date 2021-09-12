public class STO13 {

	public STO13() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}



class Solution_STO13 {
	private int result=0;
	private int[][] directions={{0,1},{0,-1},{-1,0},{1,0}};
	
	private boolean check(int a,int b,int bound) {
		int sum=0;
		String str1=String.valueOf(a);
		String str2=String.valueOf(b);
		for(int i=0;i<str1.length();i++) {
			sum+=Integer.valueOf(str1.substring(i,i+1));
		}
		for(int i=0;i<str2.length();i++) {
			sum+=Integer.valueOf(str2.substring(i,i+1));
		}
		return sum<=bound;
	}
	
	
    public int movingCount(int m, int n, int k) {
        boolean[][] help_arr=new boolean[m][n];
        
        search(0, 0, help_arr, k);
        
        return result;
    }
    
    private void search(int x,int y,boolean[][] help_arr,int bound) {
    	System.out.println(x);
    	System.out.println(y);
    	
    	int x_len=help_arr.length;
    	int y_len=help_arr[0].length;
    	
    	System.out.println("|||");
    	System.out.println(x_len);
    	System.out.println(y_len);
    	System.out.println("|||");
    	
    	if(!(x>=0&&x<x_len&&y>=0&&y<y_len)) {
            System.out.println("=");
    		return;
    	}
        else if(help_arr[x][y]==true){
            System.out.println("==");
            return;
        }
    	else {
			help_arr[x][y]=true;
            System.out.println("===");
		}

		if(check(x, y, bound)) {
			System.out.println("yeah");
			result++;
			for(var dire:directions) {
				search(x+dire[0], y_len+dire[1], help_arr, bound);
			}
		}
		// System.out.println("===");

	}
}





















