import java.util.ArrayList;
import java.util.List;

public class LC257T {

	public LC257T() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
}


class Solution257 {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }
	
	private String add_point(String oldStr,TreeNode node) {
		return oldStr+"->"+node.val;
	}
	
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res=new ArrayList<>();
    	recurse_search(root, "", res);
        return res;
    }
    
    public void recurse_search(TreeNode node,String curStr,List<String> strList) {
    	if(node.left==null&node.right==null) {
    		strList.add(add_point(curStr, node));
    		return;
    	} 
    	if(node.right!=null){
    		recurse_search(node.right, add_point(curStr, node), strList);
		}
    	if(node.left!=null){
    		recurse_search(node.right, add_point(curStr, node), strList);
		}
    }
}














