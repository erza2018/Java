import java.util.Hashtable;

public class L205_E_IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return true;

        Hashtable<Character, Character> hash = new Hashtable<Character, Character>();

        // match letters to other letters
        for(int i = 0; i < s.length(); i ++){
            // check if the letter is already in the table and if the corresponding 
            // characters match
            if(hash.containsKey(s.charAt(i))){
                // if we try to match a key to a second value, it's not isomorphic
                if(hash.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
            else if(hash.containsValue(t.charAt(i))){
                // if we try to match a new key to an existing value
                // it's not isomorphic
                return false;
            }
            else{
                hash.put(s.charAt(i), t.charAt(i));
            }
            
        }
        return true;
    }

     public static void main(String[] args) {
        //boolean test1 = isIsomorphic("egg", "add");
        
    }
}