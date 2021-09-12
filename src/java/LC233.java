import java.util.ArrayList;
import java.util.List;

public class LC233 {

	public LC233() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var solution=new Solution233();
		System.out.println(solution.countDigitOne(100));
	}

}



class Solution233 {
	private int  get_digit_length(int number) {
		return String.valueOf(number).length();
	}
	
	private List<Integer> get_pre_array(int length) {
		List<Integer> res=new ArrayList<>();
		res.add(1);

		for(var i=2;i<length;i++) {
			int child_number=res.get(res.size()-1);
			int single_iter_times=(int)Math.pow(10,i-1); // mandatory convert
			int parent_num=child_number*10+single_iter_times;
			res.add(parent_num);
		}
		return res;
	}
	
	
	private int search_recurse(int number,int length,int biggest_mod,List<Integer> pre_array) {
		
		if(number==0) {
			return 0;
		}
		
		if(length==1) {
			return number>0?1:0;
		}
		
		int quotient=number/biggest_mod;
		int remainder=number%biggest_mod;
		
		if(quotient==1) {
			int tmpInt=pre_array.get(pre_array.size()-1);
			pre_array.remove(pre_array.size()-1);
			return tmpInt+remainder+1+countDigitOne(remainder);
		}
		else {
			int sum=0;
			sum+=quotient*pre_array.get(pre_array.size()-1)+biggest_mod;
			pre_array.remove(pre_array.size()-1);
			return sum+countDigitOne(remainder);
		}
	}
	
	
	
    public int countDigitOne(int n) {
        int n_length=get_digit_length(n);
        if(n==1) return n>0?1:0;
        
        List<Integer> pre_array=get_pre_array(n_length);
        int biggest_mod=(int)Math.pow(10, n_length-1);
        
//        System.out.println(n);
//        System.out.println(n_length);
//        System.out.println(biggest_mod);
//        System.out.println(pre_array);
        
    	
    	return search_recurse(n, n_length, biggest_mod, pre_array);
    }
}


















