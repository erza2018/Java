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

        /* O(1) space solution using two pointers. If cycle, the fast will meet the slow
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
        */
    }
}