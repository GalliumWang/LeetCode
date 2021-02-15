import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LC212 {

	public LC212() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        var res=new ArrayList<String>();
        
        for (String iteredStr : words) {
			if(checkWord(board, iteredStr)) {
				res.add(iteredStr);
			}
		}
        
        return res;
    }
    
    private boolean checkWord(char[][] board,String word) {
		int rowNum=board.length;
		int colNum=board[0].length;
		
		List<List<Integer>> startIdx = new ArrayList<>();
		
		for (int i = 0; i < board.length; i++) {
			char[] cs = board[i];
			for (int j = 0; j < cs.length; j++) {
				char c = cs[j];
				if(c==word.charAt(0)) {
					startIdx.add(List.of(i,j));
				}
			}
			
		}
		
		for (List<Integer> singleIdx : startIdx) {
			boolean[][] onStack=new boolean[rowNum][colNum];
			var searchRes=searchWord(board, onStack, singleIdx.get(0), singleIdx.get(1), rowNum, colNum);
			if(searchRes==true) {
				return true;
			}
		}		
		
		return false;
	}
    
    private boolean searchWord(char[][] board,boolean[][] onStack,int row,int col,int rowNum,int colNum) {
		
    	return false;
	}
}













