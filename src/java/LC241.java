import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class LC241 {

	public LC241() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution241 solution=new Solution241();
		solution.diffWaysToCompute("2*3-4*5");
	}

}

/**
 * 
 * 	   give different priority to every operator in string and convert it to reverse Polish notation
 * and then calculate it
 *
 */

class Solution241 {
	private List<List<Integer>> getPermutation(int n) {
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(i);
		}
		
		var res=listPermutations(list);
		return res;
	}
	
	private List<String> str_to_element_list(String str) {
		List<String> res=new ArrayList<String>();
		res.add(Character.toString(str.charAt(0)));
		
		for(int i=1;i<str.length();i++) {
			char currenChr=str.charAt(i);
			String lastStr=res.get(res.size()-1);
			if(Character.isDigit(lastStr.charAt(lastStr.length()-1))&&Character.isDigit(currenChr)) {
				res.set(res.size()-1,lastStr+Character.toString(currenChr));
			}
			else {
				res.add(Character.toString(currenChr));
			}
		}
		
		return res;
	}
	
	
	private Stack<String> calResult(List<String> exp_list,List<Integer> permutation) {
		Stack<Integer> priority_stk=new Stack<>();
		Stack<String> opt_stk=new Stack<>();
		
		Stack<String> reverse_polish_stk=new Stack<>();
		
		for(String element:exp_list) {
			if(Character.isDigit(element.charAt(0))) {
				reverse_polish_stk.push(element);
			}
			else {
				int current_pri=permutation.get(0);
				while(!opt_stk.empty()&&priority_stk.peek()<current_pri) {
					priority_stk.pop();
					reverse_polish_stk.push(opt_stk.pop());
				}
				opt_stk.push(element);
				permutation.remove(0);
				priority_stk.push(current_pri);
			}
		}
		
		while(!opt_stk.empty()) {
			reverse_polish_stk.push(opt_stk.pop());
		}	
		return reverse_polish_stk;
	}
	
	private int reverse_polish_to_num(Stack<String> stk) {
		Stack<String> tmpStk=new Stack<>();
		while(!stk.empty()) {
			tmpStk.push(stk.pop());
		}
		Stack<Integer> resStk=new Stack<>();
		while(!tmpStk.empty()) {
			String tmpStr=tmpStk.pop();
			if(Character.isDigit(tmpStr.charAt(0))) {
				resStk.push(Integer.parseInt(tmpStr));
			}
			else {
				int num2=resStk.pop();
				int num1=resStk.pop();
				
				switch (tmpStr) {
				case "+":
					resStk.push(num1+num2);
					break;
				case "-":
					resStk.push(num1-num2);
					break;
				case "*":
					resStk.push(num1*num2);
					break;
				default:
					break;
				}
			}
		}
		
		return resStk.pop();
		
	}
	
    public List<Integer> diffWaysToCompute(String expression) {
    	List<Integer> res=new ArrayList<>();
    	List<String> exp_list=str_to_element_list(expression);
    	
    	if(exp_list.size()==1) {
    		int tmpNum=Integer.parseInt(exp_list.get(0));
    		res.add(tmpNum);
    		return res;
    	}
    	
    	// if(expression.length()%2==0) {
    	// 	System.out.println("wrong input string");
    	// 	return null;
    	// }
        
    	int op_nums=(expression.length()-1)/2;
    	var permutaions=getPermutation(op_nums);

    	
    	Set<String> dup_detect_set=new HashSet<>();
    	
    	for(var per:permutaions) {
    		Stack<String> tmpStk=calResult(exp_list, per);
    		// System.out.println(tmpStk);
    		if(!dup_detect_set.contains(tmpStk.toString())) {
    			dup_detect_set.add(tmpStk.toString());
    			res.add(reverse_polish_to_num(tmpStk));
    		}
    	}
    	
    	
    	return res;
    }
    
    public static List<List<Integer>> listPermutations(List<Integer> list) {

        if (list.size() == 0) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }

        List<List<Integer>> returnMe = new ArrayList<List<Integer>>();

        Integer firstElement = list.remove(0);

        List<List<Integer>> recursiveReturn = listPermutations(list);
        for (List<Integer> li : recursiveReturn) {

            for (int index = 0; index <= li.size(); index++) {
                List<Integer> temp = new ArrayList<Integer>(li);
                temp.add(index, firstElement);
                returnMe.add(temp);
            }

        }
        return returnMe;
    }
}



















