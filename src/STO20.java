import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class STO20 {

	public STO20() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_STO20 solution=new Solution_STO20();
		solution.isNumber("1");
	}

}


class Solution_STO20 {
    public boolean isNumber(String s) {
    	s=s.trim();
    	if(s.equals("")) return false;
    	Pattern pattern=Pattern.compile("^[+-]?((\\d+\\.?\\d*)|(\\.?\\d+))([Ee][+-]?\\d+)?$");
    	Matcher matcher=pattern.matcher(s);
    	boolean result=matcher.find();
    	return result;
    }
}














