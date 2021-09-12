import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC242 {

	public LC242() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution242 {
    public boolean isAnagram(String s, String t) {
        char[] ch1 = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch1[i] = s.charAt(i);
        }
        
        char[] ch2 = new char[t.length()];
        for (int i = 0; i < t.length(); i++) {
            ch2[i] = t.charAt(i);
        }
        
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        
        System.out.println(ch1);
        System.out.println(ch2);
        
        if(Arrays.equals(ch1, ch2)) {
        	return true;
        }
        else {
			return false;
		}
        
        
    }
}

class Solution_unicode {
    public boolean isAnagram(String s, String t) {
        if (s==null && t==null) return true;
        else if (s==null || t==null) return false;
        else if (s.length() != t.length()) return false;
        
        Map<Integer, Integer> dict = new HashMap<>();
        
        int index = 0;
        while(index < s.length()) {
            int charCode = s.codePointAt(index); // Get the integer representation of Unicode 
            dict.put(charCode, dict.getOrDefault(charCode, 0) + 1);
            index += Character.charCount(charCode); // The Unicode could be represented by either one char or two chars
        }
        
        index = 0;
        while(index < t.length()) {
            int charCode = t.codePointAt(index);
            int count = dict.getOrDefault(charCode, 0);
            
            if (count == 0) return false;
            else dict.put(charCode, count - 1);
            
            index += Character.charCount(charCode);
        }
        
        return true;
    }
}













