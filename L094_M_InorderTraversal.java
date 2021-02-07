import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L094_M_InorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversalIterative(TreeNode root){
        Stack<TreeNode> seen = new Stack<TreeNode>();
        List<Integer> traversal = new ArrayList<Integer>();
        TreeNode curr = root;
        
        while(curr != null || !seen.isEmpty()){
            while(curr != null){
                seen.add(curr);
                curr = curr.left;
            }
            TreeNode temp = seen.pop();
            traversal.add(temp.val);
            curr = temp.right;
            
        }
        return traversal;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> order = new ArrayList<Integer>();

        helper(root, order);

        return order;

    }
    
    public void helper(TreeNode root, ArrayList<Integer> order){
        if(root != null){
            if(root.left != null){
                helper(root.left, order);
            }

            order.add(root.val);

            if(root.right != null){
                helper(root.right, order);
            }
        }
    }


}