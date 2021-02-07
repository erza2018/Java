public class L071_M_SimplifyPath {
    public static String SimplifyPath(String path) {
        // split the string by / 
        
        String[] words = path.split("/");
        StringBuilder toReturn = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            if(words[i].length() == 0 || words[i].equals(".") || words[i].equals("..")){
                // do nothing
            }
            else{
                toReturn.append('/');
                toReturn.append(words[i]);
            }
        }
        return toReturn.toString();
    }
    public static void main(String[] args) {
        System.out.println(SimplifyPath("/home/"));
    }
}
