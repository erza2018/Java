import javax.lang.model.util.ElementScanner6;

public class L938_E_RangeSumBST {

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

    public int rangeSumBST(TreeNode root, int L, int R) {
        return rangeSumHelper(root, L, R, 0);

        

    }

    public int rangeSumHelper(TreeNode root, int L, int R, int sum){
        int finalSum = sum;
        if(root == null) return sum;
        if(root.val <= R && root.val >= L){
            sum += root.val;

            //recurse left
            int leftSum = rangeSumHelper(root.left, L, R, sum);
            finalSum = rangeSumHelper(root.right, L, R, leftSum);

        }
        else if(root.val < L){
            finalSum = rangeSumHelper(root.right, L, R, sum);
        }
        else{
            finalSum = rangeSumHelper(root.left, L, R, sum);
        }

        return finalSum;
    }


    
}
}