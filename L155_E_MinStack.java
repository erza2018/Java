import java.util.ArrayList;
import java.util.Stack;

public class L155_E_MinStack {
    
}

class MinStack {

    final Stack<Integer> s1;
    final Stack<Integer> s2;


    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
        if(s2.empty() || x <= s2.peek()){
            s2.push(x);
        }
    }
    
    public void pop() {
        if(s2.peek().equals(s1.peek())){
            s2.pop();
        }

        s1.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {

        return s2.peek();
        
    }
}