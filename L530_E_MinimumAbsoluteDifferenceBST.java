import java.util.*;

public class L530_E_MinimumAbsoluteDifferenceBST {
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

    public int getMinimumDifference(TreeNode root) {
        List<Integer> treeVals = inorderTraversal(root);
        int greatestDiff = Integer.MAX_VALUE;
        for(int i = 0; i < treeVals.size()-1; i++){
            int temp = treeVals.get(i+1) - treeVals.get(i);
            if(temp < greatestDiff){
                greatestDiff = temp;
            }
        }
        return greatestDiff;
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