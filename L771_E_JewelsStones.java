public class L771_E_JewelsStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(J.contains("" + S.charAt(i))){
                count++;
            }
        }

        return count;
    }
}