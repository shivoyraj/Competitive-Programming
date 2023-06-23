/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//solution using single pointers
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null)
            return null;
        
        int t = 0;
        ListNode p = head;
        
        while(p!=null){
            p = p.next;
            t++;
        }

        if(t==n){
            head = head.next;
            return head;
        }

        p = head;
        for(int i = 1; i < t-n ; i++ )
            p = p.next;
        
        p.next = p.next.next;

        return head;
    }
}

// solution using two pointers and single Iteration of list
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;     

        for(int i = 1; i <= n; ++i)
            fast = fast.next;
    
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return start.next;
        
    }
}