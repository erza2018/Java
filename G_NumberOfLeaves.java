public class G_NumberOfLeaves{

    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    int countLeaves(Node node) 
    {
         // Your code  
         if(node == null) return 0;
         if(node.left == null && node.right == null){
             return 1;
         }
         else{
             return countLeaves(node.left) + countLeaves(node.right);
         }

    }
}