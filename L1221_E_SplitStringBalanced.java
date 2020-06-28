public class L1221_E_SplitStringBalanced {
    public int balancedStringSplit(String s) {
        int count = 0;
        int r = 0; 
        int l = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'R') r++;
            if(s.charAt(i) == 'L') l++;

            if(r > 0 && l > 0 && r == l){
                r = 0;
                l = 0;
                count++;
            }
        }

        return count;
    }
}