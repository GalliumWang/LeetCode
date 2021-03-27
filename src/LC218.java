import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC218 {

	public LC218() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
    	// pre process
    	List<List<Integer>> lists = new ArrayList<>();
    	for (int[] ints : buildings) {
    	    List<Integer> list = new ArrayList<>();
    	    for (int i : ints) {
    	        list.add(i);
    	    }
    	    lists.add(list);
    	}
    	
    	List<List<Integer>> resList=new ArrayList<>();
    	
    	int drawingpointPre=0;
        int drawingpoint=0;
        
        int leftBorder=0; // for edge case
        int rightBorder=0;
        
        rightBorder=lists.stream().max((x, y) -> x.get(1) - y.get(1)).get().get(1);
        
        
        List<Integer> point_set=new ArrayList<>();
        
        for(var list:lists) {
        	point_set.add(list.get(0)-1);
        	point_set.add(list.get(0));
        	point_set.add(list.get(0)+1);
        	
        	point_set.add(list.get(1)-1);
        	point_set.add(list.get(1));
        	point_set.add(list.get(1)+1);
        }
        
        
        // remove duplicates
        point_set=point_set.stream()
        	     .distinct()
        	     .collect(Collectors.toList());
        
        Collections.sort(point_set); 
        
        
        point_set.remove(point_set.size()-1);
        
        
        for (int i:point_set) {
        	final int i_copy=i;
        	//get highest value
        	var outValue=0;
			var outList=lists.stream().max(
				(x,y) -> {
					var xMax=0;
					if(x.get(0)<=i_copy && x.get(1)>i_copy) xMax=x.get(2);
					var yMax=0;
					if(y.get(0)<=i_copy && y.get(1)>i_copy) yMax=y.get(2);
					return xMax-yMax;
				}).get();
			
			if(outList.get(0)<=i && outList.get(1)>i) {
				outValue=outList.get(2);
			}
			
//			System.out.println("=====");
//			System.out.println(i);
//			System.out.println(outValue);
			
			
			drawingpoint=outValue;
			if(drawingpoint>drawingpointPre) {
				resList.add(
						List.of(i,drawingpoint)
						);
				
			}
			else if (drawingpoint<drawingpointPre) {
				resList.add(
						List.of(i,drawingpoint)
						);
			}
			
			
								  		
			drawingpointPre=drawingpoint;
			
		}
        
        //resList.add(List.of(rightBorder,0));
        
        if(rightBorder==2147483647) {
        	resList.add(List.of(2147483647,0));
        }
        
    	
    	return resList;
    }
}












