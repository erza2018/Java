public class L125_E_ValidPalindrome {
    public static boolean isPalindrome(String s){
        
        // base cases
        if(s.length() == 0) return true;
        if(s.length() == 1) return true;

        //standardize casing and get rid of punctuation/whitespace
        s = s.toUpperCase();
        s = s.replaceAll("\\p{Punct}", "");
        s = s.replaceAll(" ", "");
        
        //SOLUTION ONE
        // split string into two halves and check equality
        // String secondHalf = "";

        // for(int i = s.length() - 1; i >= s.length()/2; i--){
        //     if(s.length() % 2 == 1 && i == s.length()/2){
        //         // if there's an odd number of letters, we don't want the middle letter here
        //     }
        //     else{
        //         secondHalf = secondHalf + s.charAt(i);
        //     }
        // }

        // s = s.substring(0, s.length()/2);


        //SECOND SOLUTION

        // use two pointers and a while loop
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

        //return s.equals(secondHalf);
    }

    public static void main(String[] args){
        System.out.println(isPalindrome("racecar"));
    }
}