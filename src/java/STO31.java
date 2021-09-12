import java.util.*;

public class STO31 {

	public STO31() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_STO31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	 List<Integer> push_arr=new ArrayList<>();
    	 List<Integer> pop_arr=new ArrayList<>();
    	 for(var i:pushed) {
    		 push_arr.add(i);
    	 }
    	 for(var i:popped) {
    		 pop_arr.add(i);
    	 }
    	 
    	 
    	 boolean[] popStatus=new boolean[pushed.length];
    	 int pushStatus=-1;
    	 for(int i=0;i<popped.length;i++) {
    		 int current_pop=pop_arr.get(i);
    		 int push_idx=push_arr.indexOf(current_pop);
    		 if(push_idx>pushStatus) {
    			 pushStatus=push_idx;
    			 popStatus[push_idx]=true;
    		 }
    		 else {
    			popStatus[push_idx]=true;
				for(int j=push_idx+1;j<pushStatus;j++) {
					if(popStatus[j]==false) return false;
				}
			}
    	 }
    	 return true;
    }
}
















