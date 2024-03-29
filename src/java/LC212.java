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


class Solution212 {
	public final int[][] stepDire= {{1,0},{0,-1},{-1,0},{0,1}};
	
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
			var searchRes=searchWord(board, onStack, word, singleIdx.get(0), singleIdx.get(1), rowNum, colNum);
			if(searchRes==true) {
				return true;
			}
		}		
		
		return false;
	}
    
    private boolean searchWord(char[][] board,boolean[][] onStack,String word, int row,int col,int rowNum,int colNum) {
		if(word.length()==1) {
			return true;
		}
		
		String wordToSearch=word.substring(1);
		
		onStack[row][col]=true;
		
		for (int[] step : stepDire) {
			var newRow=row+step[0];
			var newCol=col+step[1];
			if(newRow >= 0 && newRow < rowNum && newCol >= 0 && newCol < colNum &&onStack[newRow][newCol]==false) {
				if(board[newRow][newCol]==wordToSearch.charAt(0)) {
					var newCheck=searchWord(board, onStack, wordToSearch, newRow, newCol, rowNum, colNum);
					if(newCheck==true) {
						return true;
					}
				}
			}
		}
		
		onStack[row][col]=false;
		
		
    	return false;
	}
}













