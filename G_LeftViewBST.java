public class G_LeftViewBST {
    
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

    void leftView(Node root)
    {
      // Your code here
      System.out.println(helper(root, ""));
    }

    String helper(Node root, String leftSoFar){
        leftSoFar = leftSoFar + root.data + " ";

        if(root.left != null){
            return helper(root.left, leftSoFar);
        }
        else{
            return leftSoFar;
        }
    }

}