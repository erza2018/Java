public class L014_E_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        //base cases
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        String toReturn = "";

        for(int i = 0; i < strs[0].length(); i++){
            char toCheck = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++){
                if(i > strs[j].length() - 1 || strs[j].charAt(i) != toCheck){
                    return toReturn;
                }
                else{
                    //do nothing
                }

            }
            toReturn = toReturn + toCheck;
        }
        return toReturn;

    // OTHER SOLUTION
    //     if (strs.length == 0) return "";
    //     String prefix = strs[0];

    // loop through the array            
    //    for (int i = 1; i < strs.length; i++)
                // while the segment we're checking isn't at the beginning of the entry
                // keep removing one char from the end of the prefix until either the segment is the prefix 
                // or until the prefix is empty
    //          while (strs[i].indexOf(prefix) != 0) {
    //              prefix = prefix.substring(0, prefix.length() - 1);
    //              if (prefix.isEmpty()) return "";
    //     }        
    // return prefix;

        



    }
}