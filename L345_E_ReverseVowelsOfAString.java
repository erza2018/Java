import java.util.ArrayList;

public class L345_E_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if(s.isEmpty()) return "";



        String vowels = "aeiouAEIOU";

        ArrayList<Character> vowelOrder = new ArrayList<Character>();
        ArrayList<Integer> indices = new ArrayList<Integer>();
        char[] stringChars = s.toCharArray();

        for(int i = 0; i < stringChars.length; i++){
            if(vowels.contains("" + stringChars[i])){
                // if we find a vowel

                // add it to the list of vowels in order
                vowelOrder.add(stringChars[i]);

                // add the index to the indices array
                indices.add(i);
            }
        }

        // iterate through the indices arraylist 
        // add the chars in backwards order
        for(int i = 0; i < indices.size(); i++){
            // set the vowel at the index i to the next to last vowel from the vowelOrder arrayList
            stringChars[indices.get(i)] = vowelOrder.get(vowelOrder.size() - 1 - i);
        }

        return String.valueOf(stringChars);
    }
}