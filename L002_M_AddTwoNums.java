public class L002_M_AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        boolean carry = false;
        ListNode sum = new ListNode(l1.val + l2.val);
        if(sum.val >= 10){
            sum.val = sum.val % 10;
            carry = true;
        }
        ListNode finger1 = l1.next;
        ListNode finger2 = l2.next;
        ListNode finger3 = sum;
        

        while(!(finger1 == null && finger2 == null)) {
            int digit = 0;
            if(carry){
                digit++;
                carry = false;
            }

            if(finger1 == null){
                digit += finger2.val;
                finger2 = finger2.next;
            }
            else if(finger2 == null){
                digit += finger1.val;
                finger1 = finger1.next;
            }
            else{
                digit += finger1.val + finger2.val;
                finger1 = finger1.next;
                finger2 = finger2.next;
            }
            
            if(digit >= 10){
                digit = digit % 10;
                carry = true;
            }

            finger3.next = new ListNode(digit);
            finger3 = finger3.next;
            
        }

        if(carry){
            finger3.next = new ListNode(1);
        }
        return sum;

    }
}