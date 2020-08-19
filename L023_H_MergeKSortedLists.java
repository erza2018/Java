import java.util.PriorityQueue;

public class L023_H_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>();

        for(ListNode l : lists){
            if(l!=null){
                pq.add(l);
            }        
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!pq.isEmpty()){ 
            point.next = pq.poll();
            point = point.next; 
            ListNode next = point.next;
            if(next!=null){
                pq.add(next);
            }
        }
        return head.next;
    }
}