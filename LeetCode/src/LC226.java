
public class LC226 {

	public LC226() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}


//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}


class Solution226 {
    public TreeNode invertTree(TreeNode root) {
       if (root==null) {
		return root;
	}
       TreeNode tmpNode;
       tmpNode=root.left;
       root.left=root.right;
       root.right=tmpNode;
       invertTree(root.left);
       invertTree(root.right);
       
       return root;
    }
}



















