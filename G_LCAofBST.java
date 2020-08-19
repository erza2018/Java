public class G_LCAofBST{
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
    Node LCA(Node root, int n1, int n2){

        

        if(root == null) return null;

        if(root.data > n1 && root.data > n2){
            return LCA(root.left, n1, n2);

        }
        else if(root.data < n1 && root.data < n2){
            return LCA(root.right, n1, n2);
        }
        else{
            return root;
        }

    }
}

