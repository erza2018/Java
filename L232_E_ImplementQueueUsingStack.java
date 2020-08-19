import java.util.Stack;

public class L232_E_ImplementQueueUsingStack {
    
}
class MyQueue {

    public Stack<Integer> theQueue;
    public Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        theQueue = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!theQueue.empty()){
            stack2.push(theQueue.pop());
        }
        theQueue.push(x);
        while(!stack2.empty()){
            theQueue.push(stack2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return theQueue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return theQueue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return theQueue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


