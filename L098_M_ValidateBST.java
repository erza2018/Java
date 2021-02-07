public class L098_M_ValidateBST {
    boolean isValid = true;
    public boolean isValidBST(L094_M_InorderTraversal.TreeNode root) {
        isValidBSTRecursive(root, null, null);
        return isValid;    
    }
    public void isValidBSTRecursive(L094_M_InorderTraversal.TreeNode root, Integer lower, Integer upper) {
        if(isValid == false) return;
        if(root == null) return;
        
        if(root.left != null){
            if(lower != null && root.left.val <= lower) isValid = false;
            if(root.left.val >= root.val){
                isValid = false;
            }
        }
        if(root.right != null){
            if(upper != null && root.right.val >= upper) isValid = false; 
            if(root.right.val <= root.val){
                isValid = false;
            }
        }
 
        isValidBSTRecursive(root.left, lower, root.val);
        isValidBSTRecursive(root.right, root.val, upper);
    }
}
