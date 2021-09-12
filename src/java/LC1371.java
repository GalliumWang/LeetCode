import java.util.Arrays;

public class LC1371 {

	public LC1371() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution1371_TLE {
    public int findTheLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) {
    		switch (s.charAt(0)) {
			case 'a':
				return 0;
			case 'e':
				return 0;
			case 'i':
				return 0;
			case 'o':
				return 0;
			case 'u':
				return 0;
			default:
				return 1;
			}
        }
        
        int[] help_arr=new int[s.length()];
        int[] last_element_arr=new int[s.length()];

        last_element_arr[0]=-1;
        int last_element;
        
        if(count_or_not(s.charAt(0))) {
        	help_arr[0]=0;
        	last_element=0;
        }
        else {
			help_arr[0]=1;
			last_element=-1;
		}
        


        
        for(int i=1;i<s.length();i++) {
        	if( count_or_not(s.charAt(i)) ) {
        		last_element_arr[i]=last_element;
                last_element=i;
        		help_arr[i]=single_max_helper(s, i,last_element_arr);

        	}
        	else {
				help_arr[i]=help_arr[i-1]+1;
				last_element_arr[i]=last_element;
			}
        }
        
        
        for(var i:help_arr) {
        	System.out.print(i);
        	System.out.print("  ");
        }
        
        System.out.println("");
        
        for(var i:last_element_arr) {
        	System.out.print(i);
        	System.out.print("  ");
        }
        System.out.println("");
        
        return Arrays.stream(help_arr).max().getAsInt();
        
    	
    }
    
    private int single_max_helper(String s,int idx,int[] last_element_arr) {
    	int originalIdx=idx;
    	int length=0;
    	
		boolean a=true,e=true,i=true,o=true,u=true;
		
    	while(idx>=0) {
    		switch (s.charAt(idx)) {
			case 'a':
				a=!a;
				break;
			case 'e':
				e=!e;
				break;
			case 'i':
				i=!i;
				break;
			case 'o':
				o=!o;
				break;
			case 'u':
				u=!u;
				break;
			default:
				break;
			}

    		idx=last_element_arr[idx];
    		
    		if(a&&e&&i&&o&&u) {
    			length=originalIdx-idx;
    		}
    		
    		if(idx==-1) {
        		if(a&&e&&i&&o&&u) {
        			length=originalIdx+1;
        		}
//        		System.out.println("ppp");
//        		System.out.println(length);
//        		System.out.println("yyy");
        		return length;
    		}
    	}
    	
    	return length;
	}
    
    private boolean count_or_not(char chr) {
		switch (chr) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		default:
			return false;
		}
	}
}
















