public class L151_M_ReverseWordsInString {
    public String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll(" +", " ");
        String[] words = s.split(" ");
        reverseArray(words, 0, words.length);
        String toReturn = "";
        for(String word : words){
            if(!word.equals(" ")){
                toReturn = toReturn + word + " ";
            }
            
        }
        return toReturn.trim();
    }
    public static void reverseArray(String[] s, int start, int end) {
        for (int i = start; i < (end-start) / 2 + start; i++) {
            String temp = s[i];
            s[i] = s[end - 1 - i + start];
            s[end - 1 - i + start] = temp;
        }
    }
}