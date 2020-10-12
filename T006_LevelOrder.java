import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class T006_LevelOrder {
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

    public void levelOrder(TreeNode head){
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(head);
        while(!nodes.isEmpty()){
            TreeNode current = nodes.remove();
            System.out.print(current.value + " ");
            if(current.left != null){
                nodes.add(current.left);
            }
            if(current.right != null){
                nodes.add(current.right);
            }
            
        }
    }
}
