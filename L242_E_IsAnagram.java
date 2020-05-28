import java.util.Arrays;

public class L242_E_IsAnagram {
    public boolean isAnagram(String s, String t) {
        //test edge cases
        if (s.length() != t.length()) {
            return false;
        }
        
        //code
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}