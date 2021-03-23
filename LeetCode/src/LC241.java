import java.util.ArrayList;
import java.util.List;
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
	
	
	private int calResult(List<String> exp_list,List<Integer> permutation) {
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
		
		/**
		 * calculate reverse polan expression
		 * need to remove duplication first
		 */
		// TODO
		System.out.println(reverse_polish_stk);
		
		return 0;
	}
	
    public List<Integer> diffWaysToCompute(String expression) {
    	List<String> exp_list=str_to_element_list(expression);
    	
    	if(expression.length()%2==0) {
    		System.out.println("wrong input string");
    		return null;
    	}
        
    	int op_nums=(expression.length()-1)/2;
    	var permutaions=getPermutation(op_nums);
    	List<Integer> res=new ArrayList<>();
    	
    	for(var per:permutaions) {
    		System.out.println(per);
    		calResult(exp_list, per);
//    		int tmpInt=calResult(exp_list, per);
//    		res.add(tmpInt);
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



















