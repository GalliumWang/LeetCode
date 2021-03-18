
public class LC235 {

	public LC235() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}







class Solution235 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    	int a=Math.min(p.val, q.val);
    	int b=Math.max(p.val, q.val);
    	

    	outLoop:
    	while(true) {
            // System.out.println(root.val);
    		var tmpInt=check_position(root.val, a, b);
            // System.out.println(tmpInt);
    		switch (tmpInt) {
			case -1:
				root=root.right;
				break;
			case 1:
				root=root.left;
				break;
			case 0:
				break outLoop;
			default:
				break;
			}
    	}

    	return root;
    }

    private int check_position(int checked_num,int a,int b) {
		if(checked_num>=a&&checked_num<=b) {
			return 0;
		}
		else if(checked_num<a) {
			return -1;
		}
		else {
			return 1;
		}
		
	}
}


















