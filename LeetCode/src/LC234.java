import java.util.*;

public class LC234 {

	public LC234() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution234 {
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	private boolean oddCheck(List<Integer> ary1,List<Integer> ary2) {
		return true;
	}
	
	private boolean evenCheck(List<Integer> ary1,List<Integer> ary2) {
		return true;
	}
	
    public boolean isPalindrome(ListNode head) {
    	if(head==null||head.next==null) {
    		return true;
    	}
    	
        List<Integer> ary1=new ArrayList<Integer>();
        List<Integer> ary2=new ArrayList<Integer>();
        
        ListNode selfTail=head;
        ListNode selfHead=head;
        
        ary1.add(head.val);
        ary2.add(head.val);
        
        while(selfHead.next!=null) {
        	selfHead=selfHead.next;
        	ary2.add(selfHead.val);
        	if(selfHead.next==null) {
        		break;
        	}
        	else {
            	selfHead=selfHead.next;
            	ary2.add(selfHead.val);
            	selfTail=selfTail.next;
            	ary1.add(selfTail.val);
			}
        }
        
        if(ary2.size()%2==1) {
        	
        }
        else {
			
		}
    	
    	
    	return false;
    }
}


















