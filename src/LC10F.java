import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class LC10F {

	public LC10F() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution10 {
	boolean[][] result;
	
    public boolean isMatch(String s, String p) {
    	if(s.length()==0||p.length()==0) {
    		return false;
    	}
    	
    	
    	//initialize
    	result=new boolean[p.length()][s.length()];
    	result[0][0]=p.substring(0,1).equals(".")?true:p.substring(0,1).equals(s.substring(0,1));
    	
    	for(int i=1;i<s.length();i++) {
    		result[0][i]=false;
    	}
    	
    	for(int p_idx=1;p_idx<p.length();p_idx++) {
    		for(int s_idx=0;s_idx<s.length();s_idx++) {
    			check(p_idx, s_idx, s, p);
    		}
    	}
    	
    	for(int i=0;i<p.length();i++) {
    		for(int j=0;j<s.length();j++) {
    			System.out.print(result[i][j]);
    			System.out.println(" ");
    		}
    		System.out.println("");
    	}
    	
    	return result[p.length()-1][s.length()-1];
    }
    
    
    void check(int p_idx,int s_idx,String s,String p) {
    	if(!p.substring(p_idx,p_idx+1).equals("*")) {
    		if(s_idx>0) {
    		result[p_idx][s_idx]=result[p_idx-1][s_idx-1]&&(p.substring(p_idx,p_idx+1).equals(s.substring(s_idx, s_idx+1)) || p.substring(p_idx, p_idx+1).equals("."));
    		}
    	}
    	else {
			String preChar=p.substring(p_idx-1,p_idx);
			if(result[p_idx-1][s_idx]) { result[p_idx][s_idx]=true; }
			else {
				for(int i=1;i<=s_idx;i++) {
					// System.out.println("===");
					// System.out.println(p_idx);
					// System.out.println(s_idx);
					// System.out.println(i);
					// System.out.println();
					if(singleStr(preChar, s.substring(s_idx-i,s_idx))&&result[p_idx-1][s_idx-i]) { 
						System.out.println("woo");
						result[p_idx][s_idx]=true;
					}
				}
			}
		}
    }
    
    private boolean singleStr(String originString,String checkedString) {
		Set<String> set=new HashSet<>();
		for(var chr:Arrays.asList(checkedString)) {
			set.add(chr);
		}
		
		return set.size()==1&&(originString.equals(".")||( originString.equals(set.iterator().next()) ));
	}
}















