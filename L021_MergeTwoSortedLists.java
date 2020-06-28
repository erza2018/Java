class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class L021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null){
            return null;
        }
        else if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
            

        ListNode combined;
        ListNode finger1;
        ListNode finger2;
        // determine the first value of the combined to create pointers
        if(l1.val <= l2.val){
            combined = l1;
            finger1 = l1.next;
            finger2 = l2;
        }
        else{
            combined = l2;
            finger1 = l1;
            finger2 = l2.next;
        }
        ListNode finger3 = combined;

        
        while(!(finger1 == null && finger2 == null)){
            //l1 is finished we just need to add l2
            if(finger1 == null){
                finger3.next = finger2;
                finger2 = finger2.next;
                finger3 = finger3.next;
            }
            //l2 is finished we just add finger 1
            else if(finger2 == null){
                finger3.next = finger1;
                finger1 = finger1.next;
                finger3 = finger3.next;
            }
            //compare both values and determine which to add
            else{
                if(finger1.val <= finger2.val){
                    finger3.next = finger1;
                    finger1 = finger1.next;
                }
                else{
                    finger3.next = finger2;
                    finger2 = finger2.next;
                }
                finger3 = finger3.next;
            }
        }


        return combined;
    }
}