public class L680_E_ValidPalindrome2 {
    public static boolean isPalindrome(String s){
        // base cases
        if(s.length() == 0) return true;
        if(s.length() == 1) return true;

        // use logic from previous and check if substring minus the letter is a palindrome
        int i = 0;
        int j = s.length()-1;

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return isBasicPalindrome(s.substring(i,j)) || isBasicPalindrome(s.substring(i+1, j+1));
            }
        }
        return false;
    }
    public static boolean isBasicPalindrome(String s){
        if(s.length() == 0) return true;
        if(s.length() == 1) return true;

        int i = 0;
        int j = s.length()-1;

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}