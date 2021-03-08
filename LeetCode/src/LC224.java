import java.util.Stack;

import sun.net.www.content.text.plain;

public class LC224 {

	public LC224() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		var solution=new Solution();
		solution.calculate("1+1");

	}
}



class Solution {
    public int calculate(String s) {
    	Stack<String> stk = new Stack<>();
    	
        for(int i=0;i<s.length();i++) {
        	System.out.println(stk);
//        	System.out.println(i);
//        	System.out.println("=====");
        	var newChar=s.substring(i,i+1);
//        	System.out.println(newChar);
        	
        	if(newChar.equals("(")) {
        		stk.push(newChar);
        	}
        	else if (newChar.equals(" ")) {
				continue;
			}
        	else if (newChar.equals("+")||newChar.equals("-")) {
        		System.out.println(String.valueOf(i)+" is opt");
				stk.push(newChar);
			}
        	else if (isNumChar(newChar)) {
        		System.out.println(String.valueOf(i)+"is num");
        		
				while (i+1<s.length()&&isNumChar(s.substring(i+1, i+2))) {
					newChar=newChar+s.substring(i+1, i+2);
					i++;
				}

				if (stk.empty()) {
					stk.push(newChar);
				}
				else if(stk.peek().equals("-")||stk.peek().equals("+")) {

					String opt=stk.pop();
					if (opt.equals("-")) {
						
						if (stk.empty()||!isNumChar(stk.peek())) {
							stk.add("0");
						}
					}

					String preNumStr=stk.pop();
					System.out.println("=====");
					System.out.println(preNumStr);
					System.out.println(newChar);
					System.out.println("=====");
					int preNum=Integer.parseInt(preNumStr);
					int sufNum=Integer.parseInt(newChar);
					int resultNum=0;
//					System.out.println("=====");
//					System.out.println(preNum);
//					System.out.println(sufNum);
//					System.out.println("=====");
					if (opt.equals("+")) {
						resultNum=preNum+sufNum;
					}
					else {
						resultNum=preNum-sufNum;
					}
					
					String resultNumStr=String.valueOf(resultNum);
					stk.push(resultNumStr);
				}
				else {
					stk.push(newChar);
				}
			}
        	else if (newChar.equals(")")) {
				if (isNumChar(stk.peek())) {
					String resultNumStr=stk.pop();
					stk.pop();
					stk.push(resultNumStr);
					preClr(stk);
					System.out.println("======");
					System.out.println("local res");
					System.out.println(resultNumStr);
					System.out.println("size");
					System.out.println(stk.size());
					System.out.println("stack");
					System.out.println(stk);
					System.out.println("======");
					
				}
				// else {
				// 	throw new Exception("invalid str");
				// }
			}
        }
        System.out.println("result");
        System.out.println(stk.peek());
        
        
        if(stk.size()>1) {
        	System.out.println("iter again");
        	System.out.println(stk);
        	System.out.println("=====");
        	return calculate(joinStr(stk));
        }
        
    	return Integer.valueOf(stk.pop());
    }
    
    private boolean isNumChar(String s) {
    	if(s.length()>1) return true;
    	
//    	System.out.println(s);
		return s.compareTo("0")>=0 & s.compareTo("9")<=0;
	}
    
    
    private void preClr(Stack<String> stk) {
        if(stk.size()<3) return;
		var str1=stk.pop();
		var str2=stk.pop();
		var str3=stk.pop();
		
		if(str2.equals("+")) {
			
			stk.push(String.valueOf(Integer.valueOf(str3)+Integer.valueOf(str1)));
			
			return;
		}
		if(str2.equals("-")) {
			stk.push(String.valueOf(Integer.valueOf(str3)-Integer.valueOf(str1)));
			return;
		}
		
		stk.push(str3);
		stk.push(str2);
		stk.push(str1);
		return;
		
		
	}
    
    private String joinStr(Stack<String> stk) {
    	
		String res="";
		while(!stk.empty()) {
			res=stk.pop()+res;
		}
		return res;
	}
}




















