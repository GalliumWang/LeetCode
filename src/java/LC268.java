
public class LC268G {

	public LC268G() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	}

}


class Solution268 {
	
	private void printArray(int[] nums) {
		for(var i:nums) {
			System.out.print(i);
			System.out.print("  ");
		}
		System.out.println("");
	}
    public int missingNumber(int[] nums) {

    	
    	int length=nums.length;
    	
    	int[] newArray=new int[length+1];
    	for(var i=0;i<length;i++) {
    		newArray[i]=nums[i];
    	}
    	newArray[length]=-1;
    	nums=newArray;
    	
        int scan_idx=0;
        int temp_int=0;
        
//    	printArray(nums);
    	
        while(scan_idx<length) {
        	if(nums[scan_idx]!=scan_idx) {
        		int header=scan_idx;
        		do {
//        			printArray(nums);
        			
        			if(nums[header]==-1) {
        				nums[header]=header;
        				break;
        			}
        			
            		temp_int=nums[nums[header]];	
            		nums[nums[header]]=nums[header];
            		if(header!=scan_idx) {
            			nums[header]=header;
            		}
            		else {
            			nums[scan_idx]=-1;
            		}
            		

            		header=temp_int;
            		
        			
//            		System.out.println("header");
//            		System.out.println(header);
            		
				} while (header!=-1);
        		
//        		System.out.println("break");
        	}
        	scan_idx++;
        }
        
        
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]==-1) return i;
        }
        
        return 0;
        
    }
}



























