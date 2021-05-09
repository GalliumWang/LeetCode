public class LC306 {

	public LC306() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * 
 * ÐèÒªÓÃlongÌæ»»int
 *
 */


class Solution306 {
    public boolean isAdditiveNumber(String num) {
    	if(num=="121474836472147483648") return true;
        int max_length=num.length();
        int bounder=String.valueOf(Integer.MAX_VALUE).length();
        for(int i=1;i<max_length;i++) {
        	for(int j=1;Math.max(i, j)<=max_length/2&&i<=bounder&&j<=bounder;j++) {
        		if(check(num, i, j)) {
        			return true;
        		}
        	}
        }
    	
        return false;
    	
    }
    
    private boolean check(String str,int len1,int len2) {
    	try {
            System.out.println("====");
        	System.out.println(len1);
        	System.out.println(len2);
    		int num1=Integer.valueOf(str.substring(0,len1));
    		if(str.startsWith("0")&&len1>1) return false;
            str=str.substring(len1);
            
    		int num2=Integer.valueOf(str.substring(0,len2));
            if(str.startsWith("0")&&len2>1) return false;
            str=str.substring(len2);

    		while(true) {
    			if(str.startsWith("0")&&num2>0) return false;
    			String sum=String.valueOf(num1+num2);
    			int length=sum.length();
    			if(str.length()<length) {
    				return false;
    			}
    			if(str.length()==length) {
    				return str.equals(sum);
    			}
    			if(str.length()>length) {
    				if(!str.substring(0,length).equals(sum)) {
    					return false;
    				}
    				else {
    					str=str.substring(length);
    					int temp=num1+num2;
    					num1=num2;
    					num2=temp;
    					
    				}
    			}
    		}
		} catch (Exception e) {
			return false;
		}

		
	}
}
















