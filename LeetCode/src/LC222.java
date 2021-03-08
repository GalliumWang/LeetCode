import java.util.ArrayList;
import java.util.List;

public class LC222 {

	public LC222() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


class TreeNode {
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




class Solution222 {
    public int countNodes(TreeNode root) {
    	if (root==null) {
			return 0;
		}
    	
        int deepth=getDeepth(root, 0);
    	int fullLevelNums=(1<<deepth-1)-1;
//    	System.out.println(fullLevelNums);
    	List<Integer> deepNums=new ArrayList<>();
    	deepNums.add(0);
    	
//    	System.out.println(deepth);
    	findDeepNodes(root, deepth, 1, deepNums);
//      System.out.println(deepNums);
        return fullLevelNums+deepNums.get(0);
    }
    
    private int getDeepth(TreeNode node,int currentDeepth) {
		if(node.left==null) {
			return currentDeepth+1;
		}
		else {
			return getDeepth(node.left, currentDeepth+1);
		}
	}
    
    private void findDeepNodes(TreeNode node,int lastLevel,int curLevel,List<Integer> bulkNums) {
		if(curLevel<lastLevel) {
			findDeepNodes(node.left, lastLevel, curLevel+1, bulkNums);
			findDeepNodes(node.right, lastLevel, curLevel+1, bulkNums);
			
		}
		else if (node!=null) {
			bulkNums.set(0, bulkNums.get(0)+1);
		}
	}
}











