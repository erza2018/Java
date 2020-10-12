import java.util.Stack;

public class T004_kThInOrder {
    private int count = 0;

    public class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        
        
        public TreeNode(){
            this.value = 0;
            this.left = null;
            this.right = null;
        }
        
        public TreeNode(int value, TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
    /*
    Given a Binary Tree, with the value is the # of its children + 1 (itself),
    and given an integer K, return the Kth TreeNode of the BT in in-order.
           (6)
          /   \
         (3)  (2)
        /  \    \
       (1) (1)  (1)
       
    
    go all the way to the left until curr is null
    pop
    if 
    
    

    S: 6, 
    1, 3, 

    
    k = 1
    Cur: 1
    LC = 0
    S: 6, 3, 
    
    */
    
    
    public TreeNode kThNodeInOrderNVIterative(TreeNode head, int k){

        if(k < 1) return null;
        if(head == null) return null;

        TreeNode curr = head;
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        int numPopped = 0;
        
        while(!(curr == null && nodes.isEmpty())){
            

            if(curr == null){
                TreeNode popped = nodes.pop();
                numPopped++;
                if(numPopped == k){
                    return popped;
                }
                curr = popped.right;
            }
            else{
                nodes.push(curr);
                curr = curr.left;
            }
        }
        
        
        return null;
        
    }
    
    public TreeNode kThNodeInOrderNV(TreeNode head, int k){
        //base case
        if(head == null){
            return null;
        }
        
        TreeNode result = kThNodeInOrderNV(head.left, k);
        if (result != null) {
            return result;
        }
    
        count++; 
        if (count == k)
            return head;
         
        result = kThNodeInOrderNV(head.right, k);
        return result;
    
    }
    
    public TreeNode kThInOrderIterative(TreeNode head, int k){
        //Edge Cases
        if(head == null){
            return null;
        }
        if(k > head.value || k < 1){
            return null;
        }
        
        TreeNode curr = head;
        int leftChildren = curr.left == null ? 0 : curr.left.value;
        while(leftChildren + 1 != k){
            if(leftChildren + 1 > k){
                curr = curr.left;
            }
            else{
                curr = curr.right;
                k = k - (leftChildren + 1);
            }
            leftChildren = curr.left == null ? 0 : curr.left.value;
        
        }
        
        return curr;
    }
    
    public TreeNode kThInOrder(TreeNode head, int k){
        
        //Edge Cases
        if(head == null){
            return null;
        }
        if(k > head.value || k < 1){
            return null;
        }
        
        
        
        int leftChildren = head.left == null ? 0 : head.left.value;
        
        // base case
        if(leftChildren + 1 == k){
            return head;
        }
        
        //Main Logic
        if(leftChildren >= k){
            return kThInOrder(head.left, k);
        }
        else{
            return kThInOrder(head.right, k - (leftChildren + 1));
        }
        
    }
    
    
}