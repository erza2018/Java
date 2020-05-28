public class L028_E_StrStr {
    public int strStr(String haystack, String needle) {

        if(needle.isEmpty()) return 0;
        
        return haystack.indexOf(needle);
    }
}