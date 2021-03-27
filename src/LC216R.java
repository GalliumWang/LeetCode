import java.util.ArrayList;
import java.util.List;

public class LC216R {

	public LC216R() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution216 {
	 public List<List<Integer>> combinationSum3(int k, int n) {
		    List<List<Integer>> ans = new ArrayList<>();
		    combination(ans, new ArrayList<Integer>(), k, 1, n);
		    return ans;
		}

		private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
			if (comb.size() == k && n == 0) {
				List<Integer> li = new ArrayList<Integer>(comb);
				ans.add(li);
				return;
			}
			for (int i = start; i <= 9; i++) {
				comb.add(i);
				combination(ans, comb, k, i+1, n-i);
				comb.remove(comb.size() - 1);
			}
		}
}