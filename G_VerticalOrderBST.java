import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class G_VerticalOrderBST {
    
    class Node
    {
        int data;
        Node left, right;
        
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }

    public static class MyPair
    {
        Node node;
        int hd;
        MyPair(Node n, int h)
        {
            node = n;
            hd = h;
        }
    }

    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here

        //level order traversal
        ArrayList<Integer> order = new ArrayList<Integer>();
        Queue<MyPair> pairs = new LinkedList<MyPair>();
        ArrayList<MyPair> pairAL = new ArrayList<MyPair>();


        pairs.offer(new MyPair(root, 0));

        while(!pairs.isEmpty()){
            MyPair current = pairs.poll();
            pairAL.add(current);
            if(current.node.left != null){
                pairs.add(new MyPair(current.node.left, current.hd + 1));
            }
            if(current.node.right != null){
                pairs.add(new MyPair(current.node.right, current.hd - 1));
            }
        }

        pairAL.sort(new Comparator<MyPair>(){
            
            public int compare(MyPair p1, MyPair p2){
                if(p1.hd > p2.hd){
                    return -1;
                }
                else if(p2.hd > p1.hd){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });

        for(int i = 0; i < pairAL.size(); i++){
            order.add(pairAL.get(i).node.data);
        }

        return order;

    }
}