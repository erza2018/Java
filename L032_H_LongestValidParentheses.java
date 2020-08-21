import java.util.Stack;

public class L032_H_LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int longestSoFar = 0;

        Stack<Integer> openParentheses = new Stack<Integer>();

        if(s.isEmpty()) return 0;
        openParentheses.push(-1);

        for(int i = 0; i < s.length(); i++){

            char current = s.charAt(i);
            // push all open characters to the stack
            // eventually we'll pop them when a closing one appears
            if(current == '('){
                openParentheses.push(i);
            }
            else {

                if(openParentheses.isEmpty()) {
                    openParentheses.push(i);
                }
                else{
                    longestSoFar = Math.max(longestSoFar, i-openParentheses.peek());
                }
            }
        
        }
    
        return longestSoFar;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }
}