import java.util.ArrayList;
import java.util.List;


public class LC230 {

	public LC230() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution230 {
	 private class TreeNode {
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

    public int kthSmallest(TreeNode root, int k) {
    	List<Integer> res=new ArrayList<>();
    	res.add(0);
    	res.add(null);
    	findkth(root,res,k);
    	
    	return res.get(1);
    }
    
    private void findkth(TreeNode node,List<Integer> res,int k) {
		if(node==null) return;
		findkth(node.left,res,k);
		if(res.get(1)!=null) {
			return;
		}
		res.set(0, res.get(0)+1);
		if(res.get(0)==k) {
			res.set(1, node.val);
			return;
		}
		findkth(node.right, res, k);
		return;
	}
    
    
}
















