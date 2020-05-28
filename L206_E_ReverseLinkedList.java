public class L206_E_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        if(head.next == null) return head;

        ListNode finger = head;
        ListNode prev = null;

        while(finger != null){
            ListNode nextNode = finger.next;
            finger.next = prev;
            prev = finger;
            finger = nextNode;
        }
        
        return prev;
    }

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
}