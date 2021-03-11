import java.util.Stack;

public class LC231 {

	public LC231() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyQueue {
    private Stack<Integer> stk1;
    private Stack<Integer> stk2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stk1=new Stack<>();
        stk2=new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stk2.empty()) {
        	return stk2.pop();
        }
        else {
        	while(!stk1.empty()) {
        		stk2.push(stk1.pop());
        	}
        	return stk2.pop();
        }
        
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(!stk2.empty()) {
        	return stk2.peek();
        }
        else {
        	while(!stk1.empty()) {
        		stk2.push(stk1.pop());
        	}
        	return stk2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.empty()&&stk2.empty();
    }
}


















