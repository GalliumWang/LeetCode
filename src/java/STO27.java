
public class STO27 {

	public STO27() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class Solution_STO27 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public TreeNode mirrorTree(TreeNode root) {
    	
    	switchNode(root);
    	return root;
    }
    
    private void switchNode(TreeNode node) {
		if(node==null) return;
		TreeNode nodeTemp=node.left;
		TreeNode nodeTemp2=node.right;
		node.left=nodeTemp2;
		node.right=nodeTemp;
		switchNode(node.left);
		switchNode(node.right);
	}
    
}














