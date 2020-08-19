import java.util.Stack;

    

    /*
    Given a string with char and '(' and ')', remove minimum number of '(' and/or ')'
    and make the string balanced with ( and )
    E.g.
    a(b(c(d) => abc(d)
    a)b(cd()e => abcd()e
    */

    /*
    input: a ( b ( c ( d )  
    #: 2
    a ( b ( c ( d ) ) ) e ( ) 






    result: a b c ( d )

    input a ) b ( c d ( ) e
    S: 1 3 
    result: a b c d ( ) e 

    Test Cases:
    - null or empty
    - abcd

    */
public class T002_balanceParanthesesStrings {


    public static String balanceParentheses(String s){  
        
        // Edge Cases 
        if(s == null || s.isEmpty()){
            return s;
        }
        
        // Main Logic
        Stack<Integer> parentheses = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++){
        
            char curr = s.charAt(i);
            
            // determine pairs 
            if(curr == '(' ){
                parentheses.push(i);
            }
            
            if(curr == ')'){
                if(!parentheses.isEmpty() && s.charAt(parentheses.peek()) == '('){
                    parentheses.pop();
                }
                else{
                    parentheses.push(i);
                }
            }
        }
        
        //delete remaining in stack    
        
        // opitmization
        if (parentheses.isEmpty()) return s;
        
        StringBuilder balanced = new StringBuilder();
        
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            
            if(j < parentheses.size() && i == parentheses.get(j)){
                // do nothing
                j++;
            }
            else{
                balanced.append(s.charAt(i));    
            }
        }
        
        return balanced.toString();
    }

    public static void main(String[] args){
        System.out.println(balanceParentheses(null));
        System.out.println(balanceParentheses(""));
        System.out.println(balanceParentheses("a ( b ( c ( d )  "));
        System.out.println(balanceParentheses("a)b(cd()e"));
    }


}











