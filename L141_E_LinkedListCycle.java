import java.util.Hashtable;

 

public class L141_E_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)return false;
        
        Hashtable<ListNode, Integer> hash = new Hashtable<ListNode, Integer>();
        
        while(head.next != null){
            if(hash.containsKey(head)){
                return true;
            }
            else{
                hash.put(head, 1);
                head = head.next;
            }
        }
        return false;
    }
}