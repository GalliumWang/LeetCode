public class LC223 {

	public LC223() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int coveredArea=coveredLength((long)A, (long)C, (long)E, (long)G)*coveredLength((long)B, (long)D, (long)F,(long)H);
        int areaA=(C-A)*(D-B);
        int areaB=(G-E)*(H-F);
        
    	return areaA+areaB-coveredArea;
    }
    
    private int coveredLength(long a1,long a2,long b1,long b2) {
    	long aL=Math.abs(a1-a2);
    	long bL=Math.abs(b1-b2);
		if(a1<=b1&&a2>=b2||a1>=b1&&a2<=b2) {
			return (int)(aL<bL?aL:bL);
		}
		
		if(a1>b1) {
			long tmp;
			tmp=a1;
			a1=b1;
			b1=tmp;
			
			tmp=a2;
			a2=b2;
			b2=tmp;
		}
//		System.out.println("======");
//		System.out.println(a1);
//		System.out.println(a2);
//		System.out.println(b1);
//		System.out.println(b2);
//		System.out.println("======");
//		System.out.println(a2-b1>0?a2-b1:0);
//		System.out.println("======");
		
		return (int)(a2-b1>0?a2-b1:0);
	}
}











