public class G_CheckBST {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    boolean isBST(Node root)
    {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
            
    }   
    
    boolean helper (Node node, int min, int max){

        if(node.data <= min || node.data >= max){
            return false;
        }
        else if(node.left == null && node.right == null){
            return true;
        }
        else if(node.left == null){
            return helper(node.right, node.data, max);
        }
        else if(node.right == null){
            return helper(node.left, min, node.data);
        }
        else{
            return helper(node.left, min, node.data) && helper(node.right, node.data, max);
        }

    }



}