
public class LC263 {

	public LC263() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}


class Solution263 {
    public boolean isUgly(int n) {
    	if(n==0) {
    		return false;
    	}
    	
        while(n%2==0) {
        	n/=2;
        }
        while(n%3==0) {
        	n/=3;
        }
        while(n%5==0) {
        	n/=5;
        }
        
        return n==1;
    }
}











