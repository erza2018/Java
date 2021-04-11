import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class L146_M_LRUCache {
    class Node{
        public int value;
    }
    private int capacity;
    HashMap<Integer, Node> map;
    LinkedList<Node> list;

    public L146_M_LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        this.list = new LinkedList<Node>();
        
    }
    // Return the value of the key if the key exists, otherwise return -1.
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        list.remove(node);
        list.addFirst(node);
        return node.value;
    }
    
    // Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
    // If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    public void put(int key, int value) {
        //check if the key exists
        Node node = map.get(key);
        if(node != null){
            node.value = value;
            list.remove(node);
            list.addFirst(node);
        }
        else{
            // Initialize new Node
            Node newNode = new Node();
            newNode.value = value;
            // check the number of items in the cache
            // if greater than capacity, remove the last node aka least recently used
            if(map.size() >= capacity){
                Node toRemove = list.removeLast();
                for(int item : map.keySet()){
                    if(map.get(item) == toRemove){
                        map.remove(item);
                        break;
                    }
                }
            }
            list.addFirst(newNode);
            map.put(key, newNode);
        }
    }
    public static void main(String[] args) {
        L146_M_LRUCache lRUCache = new L146_M_LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}


// ["LRUCache","put","put","get","put","get","put","get","get","get"]
// [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]





