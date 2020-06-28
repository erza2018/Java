public class L061_M_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        // find out how many don't move and then move all the rest to the end
        ListNode finger = head;
        ListNode newTailFinder = head;
        int length = 1;
        while(finger.next != null){
            length++;
            finger = finger.next;
        }

        finger.next = head; 
        int shift = length - k%length - 1;

        while(shift > 0){
            shift--;
            newTailFinder = newTailFinder.next;
        }

        ListNode newHead = newTailFinder.next;
        newTailFinder.next = null;
        return newHead;





        /*
        for(int i = 0; i < k; i++){
            head = rotateOnce(head);
        }

        return head;
        */
    }

    /*
    public ListNode rotateOnce(ListNode head){
        if(head == null){
            return null;
        }
        else if(head.next == null){
            return head;
        }
        else if(head.next.next == null){
            // make the head the next of the second node
            ListNode second = head.next;
            second.next = head;
            //make the next of the head null
            head.next = null;

            return second;
        }
        else{
            ListNode finger = head;

            //traverse to the second to last element
            while(finger.next.next != null){
                finger = finger.next;
            }

            ListNode last = finger.next;
            last.next = head;
            finger.next = null;
            return last;
        }
    }
    */
}