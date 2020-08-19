
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class A101_LinkedList {

    public static ListNode buildList (int[] numbers){
        ListNode head = new ListNode(numbers[0]);
        ListNode finger = head;

        for(int i = 1; i < numbers.length; i++){
            ListNode toAdd = new ListNode(numbers[i]);
            finger.next = toAdd;
            finger = finger.next;
        }

        return head;
    }

    public static void problems(){

        Object[] o = new Object[]{
            new L002_M_AddTwoNums(),
            new L021_MergeTwoSortedLists(),
            new L061_M_RotateList(),
            new L141_E_LinkedListCycle(),
            new L206_E_ReverseLinkedList()
        };
    }


}