import java.util.*;

public class L049_M_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();

        for(int i = 0; i < strs.length; i++){
            boolean beenAdded = false;
            for(List<String> group : groups){
                if(isAnagram(strs[i], group.get(0))){
                    group.add(strs[i]);
                    beenAdded = true;
                }
            }
            if(!beenAdded){
                ArrayList<String> newGroup = new ArrayList<String>();
                newGroup.add(strs[i]);
                groups.add(newGroup);
            }
            
        }

        return groups;

    }

    public static boolean isAnagram(String s, String t) {
        //test edge cases
        if (s.length() != t.length()) {
            return false;
        }
        
        //code
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}