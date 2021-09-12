
public class LC273 {

	public LC273() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution273 {
	private final String[] small_unit={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] middle_unit={"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] big_unit={"","Thousand","Million","Billion"};
	
    public String numberToWords(int num) {
    	if(num==0) {
    		return "Zero";
    	}
    	var result="";
		var iteration=0;
		
        while(num!=0) {
        	if(num%1000==0) {
        		num/=1000;
        		iteration++;
        		continue;
        	}
        	else {
        		int remainder=num%1000;
        		
        		String tempStr="";
        		
        		int hundred_num=remainder/100;
        		tempStr=hundred_num!=0?(small_unit[hundred_num]+" "+"Hundred"):"";
        		
        		int ten_num=remainder%100;
    			String ten_result="";
        		if(ten_num<20) {
        			ten_result=small_unit[ten_num];
        		}
        		else {

        			ten_result=middle_unit[ten_num/10];
        			if(ten_result.equals("")) {
        				if(small_unit[ten_num%10].equals("")) {
        					ten_result="";
        				}
        				else {
							ten_result=small_unit[ten_num%10];
						}
        			}
        			else {
        				if(small_unit[ten_num%10].equals("")) {
        					ten_result=ten_result;
        				}
        				else {
							ten_result=ten_result+" "+small_unit[ten_num%10];
						}
					}
				}
    			if(tempStr.equals("")) {
    				if(ten_result.equals("")) {
    					tempStr=tempStr;
    				}
    				else {
						tempStr=ten_result;
					}
    			}
    			else {
    				if(ten_result.equals("")) {
    					tempStr=tempStr;
    				}
    				else {
						tempStr=tempStr+" "+ten_result;
					}
				}
    		
    			
        		if(result.equals("")) {
        			result=iteration==0?tempStr:(tempStr+" "+big_unit[iteration]);
        		}
        		else {
        			result=tempStr+" "+big_unit[iteration]+" "+result;
        		}
        		
        		num=num/1000;
			}
        	iteration++;
        }
        
        return result;
    }
}













