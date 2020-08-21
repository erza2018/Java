import java.util.Hashtable;

public class L290_E_WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        if(pattern.isEmpty() || str.isEmpty()) return false;
        String[] strWords = str.split(" ");
        if(pattern.length() != strWords.length) return false;

        // loop through the letters and map them in a HashTable
        Hashtable<Character, String> hash = new Hashtable<Character, String>();

        for(int i = 0; i < pattern.length(); i++){
            // check if key already exists and then check if we're trying to map to the same string
            if(hash.containsKey(pattern.charAt(i))){
                if(!hash.get(pattern.charAt(i)).equals(strWords[i])){
                    return false;
                }
            }
            else if(hash.containsValue(strWords[i])){
                return false;
            }
            else{
                hash.put(pattern.charAt(i), strWords[i]);
            }
        }
            
        
        return true;
    }
    public static void main(String[] args) {

    }
}