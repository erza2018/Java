import java.util.*;

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Example 2:
// Input: n = 1
// Output: ["()"]
 


// Constraints:
// 1 <= n <= 8

public class L022_M_GenerateValidParentheses {
    public List<String> generateParenthesis(int n) {
        if(n < 1) return null;
        ArrayList<String> combinations = new ArrayList<String>();
        combinations.add("()");

        if(n == 1) return combinations;

        return generateParenthesisHelper(generateParenthesis(n-1));
    }

    // n == 2: 
    // helper(["()"])
    // hash: ["()()", "(())"]
    // combinations: ["()()", "(())"]
    // i == 1
    // check = (())

    // n == 3: 
    // hash: [()()(), (())()]
    // comb: [()()(), (())()]
    // l: ["()()", "(())"]
    // s = "()()"
    // i == 3
    // check = ()(())
    public List<String> generateParenthesisHelper(List<String> l){
        // set up variables
        List<String> combinations = new ArrayList<String>();
        HashSet<String> hash = new HashSet<String>();

        // loop through members of the prev l
        for(String s : l){
            for(int i = 0; i < s.length(); i++){
                String check = s.substring(0, i) + "()" + s.substring(i);
                if(!hash.contains(check)){
                    hash.add(check);
                    combinations.add(check);
                }
            }
        }
        return combinations;
    }
}
