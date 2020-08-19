
public class L203_E_RemoveLinkedListEl {
    public ListNode removeElements(ListNode head, int val) {

        if(head == null) return null;
        if(head.val == val) head = head.next;

        while(head != null && head.val == val){
            head = head.next;
        }

        ListNode finger = head;
        while(finger != null && finger.next != null){
            if(finger.next.val == val){
                finger.next = finger.next.next;
            }
            else{
                finger = finger.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        A101_LinkedList builder = new A101_LinkedList();
    }

}