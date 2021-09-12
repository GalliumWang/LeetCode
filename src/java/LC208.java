import java.util.*;

/**
 * 
 * also refer to LC211
 *
 */
public class LC208 {

	public static void main(String[] args) {
		 Trie trie = new Trie();
		 
		 System.out.println(1);
		 trie.insert("apple");
		 
		 System.out.println(2);
		 System.out.println(trie.search("apple"));
		 
		 System.out.println(3);
		 System.out.println(trie.search("app"));
		 
		 System.out.println(4);
		 System.out.println(trie.startsWith("app"));
		 
		 System.out.println(5);
		 trie.insert("app"); 
		 
		 System.out.println(6);
		 System.out.println(trie.search("app"));
		 
	}

}


class Trie {
    class Node{
        public Node(){
            charMap = new HashMap<String, Node>();
            charStat = new HashMap<String,Boolean>();
        }
        public HashMap<String, Node> charMap;
        public HashMap<String, Boolean> charStat;
    }
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Node preNode=null;
    	Node curNode=root;
        for(var i=0;i<word.length();i++) {
        	String curChar=word.substring(i,i+1);
        	
        	if(!curNode.charMap.containsKey(curChar)) {
        		curNode.charMap.put(curChar, new Node());
        	}
        	preNode=curNode;
        	curNode=curNode.charMap.get(curChar);       
        }
        
//        for(var entry:root.charMap.entrySet()) {
//        	System.out.println(entry.getKey());
//        }
        
        preNode.charStat.put(word.substring(word.length()-1,word.length()), true);
        
    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Node preNode=null;
    	Node curNode=root;
        for(var i=0;i<word.length();i++) {
        	String curChar=word.substring(i,i+1);
//        	System.out.println(curChar);
        	
        	if(!curNode.charMap.containsKey(curChar)) {
        		return false;
        	}
        	preNode=curNode;
        	curNode=curNode.charMap.get(curChar);       
        }
        
//        for(var entry:preNode.charStat.entrySet()){
//        	System.out.println(entry);
//        }
        var endChar=word.substring(word.length()-1,word.length() );
        
        if(preNode.charStat.containsKey(endChar)) {
        	return true;
        }
        else {
			return false;
		}
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Node preNode=null;
    	Node curNode=root;
        for(var i=0;i<prefix.length();i++) {
        	String curChar=prefix.substring(i,i+1);
        	
        	if(!curNode.charMap.containsKey(curChar)) {
        		return false;
        	}
        	preNode=curNode;
        	curNode=curNode.charMap.get(curChar);       
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */