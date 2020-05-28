public class L058_E_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        if(s.equals(" ")) return 0;

        String[] words = s.split(" ");

        return words[words.length - 1].length();
    }
}