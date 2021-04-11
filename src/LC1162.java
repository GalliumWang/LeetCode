
public class LC1162 {

	public LC1162() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



class Solution1162 {
	
	private int[][] data;
	private int dataLength;
	
    public int maxDistance(int[][] grid) {
    	
    	
        data=grid;
        dataLength=grid.length;
        
        if (dataLength==0) {
			return -1;
		}
        if(!check()) {
        	return -1;
        }
        
        
        
        init(data);
        
        for(int p=0;p<dataLength;p++) {
        for(int i=0;i<dataLength;i++) {
        	for(int j=0;j<dataLength;j++) {
        		expand(i, j);
        	}
        }
        }
        
        return find_max()-1;
        
    }
    
    
    
    
    private void init(int[][] data) {
    	for(int i=0;i<dataLength;i++) {
    		for(int j=0;j<dataLength;j++) {
    			if(data[i][j]==0) {
    				data[i][j]=dataLength*2;
    			}
    		}
    	}
		
	}
    
    
    private void expand(int rowIdx,int colIdx) {
		if(rowIdx>0) {
			if(data[rowIdx-1][colIdx] > data[rowIdx][colIdx]+1) {
				data[rowIdx-1][colIdx]=data[rowIdx][colIdx]+1;
			}
		}
		if(rowIdx<dataLength-1) {
			if(data[rowIdx+1][colIdx] > data[rowIdx][colIdx]+1) {
				data[rowIdx+1][colIdx]=data[rowIdx][colIdx]+1;
			}
		}
		if(colIdx>0) {
			if(data[rowIdx][colIdx-1] > data[rowIdx][colIdx]+1) {
				data[rowIdx][colIdx-1]=data[rowIdx][colIdx]+1;
			}
		}
		if(colIdx<dataLength-1) {
			if(data[rowIdx][colIdx+1] > data[rowIdx][colIdx]+1) {
				data[rowIdx][colIdx+1]=data[rowIdx][colIdx]+1;
			}
		}
		
		return;
		
	}
    
    
    private boolean check() {
		int original=data[0][0];
		for(int i=0;i<dataLength;i++) {
			for(int j=0;j<dataLength;j++) {
				if(data[i][j]!=original) {
					return true;
				}
			}
		}
		return false;
	}
    
    private int find_max() {
		int max=0;
		for(int i=0;i<dataLength;i++) {
			for(int j=0;j<dataLength;j++) {
				if(data[i][j]>max) {
					max=data[i][j];
				}
			}
		}
		return max;
	}
}
