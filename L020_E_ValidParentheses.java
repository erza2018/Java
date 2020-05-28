import java.util.Stack;

public class L020_E_ValidParentheses {
    
    public boolean isValid(String s) {
        Stack<Character> openParentheses = new Stack<Character>();

        if(s.isEmpty()) return true;
        if(s.length() % 2 != 0) return false;

        for(int i = 0; i < s.length(); i++){

            char current = s.charAt(i);
            // push all open characters to the stack
            // eventually we'll pop them when a closing one appears
            if(current == '(' || current == '[' || current == '{'){
                openParentheses.push(current);
            }
            else if(current == ')' || current == ']' || current == '}'){
                if(openParentheses.isEmpty()) return false;

                char corresponding = openParentheses.pop();

                if(current == ')' && corresponding != '(') return false;
                if(current == ']' && corresponding != '[') return false;
                if(current == '}' && corresponding != '{') return false;
            }
            else{
                return false;
            }

        }
        if(!openParentheses.isEmpty()) return false;
        return true;
    }
}