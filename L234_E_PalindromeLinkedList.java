import java.util.ArrayList;

public class L234_E_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> values = new ArrayList<Integer>();

        ListNode finger = head;
        while(finger != null){
            values.add(finger.val);
            finger = finger.next;
        }

        int i = 0;
        int j = values.size()-1;

        while(i < j){
            if(values.get(i).equals(values.get(j))){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;

    }
}