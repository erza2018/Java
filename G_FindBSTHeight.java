public class G_FindBSTHeight{

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

    int height(Node root){

        if(root == null) return 0;
        else{

            // traverse to all of the leaves
            int lDepth = height(root.left);
            int rDepth = height(root.right);



            // adds + 1 every layer you go up
            if(lDepth > rDepth) {
                return lDepth + 1;
            }
            else{
                return rDepth + 1;
            }
        }

    }



}