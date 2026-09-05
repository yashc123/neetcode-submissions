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

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

       ListNode curr = head;
       ListNode before = null;
       ListNode after = null;

       while(curr != null){
        after = curr.next;
        curr.next = before;
        before = curr;
        curr = after;
       }

       return before;
    }

    //after = 1, 0.next = null, before = 0, curr = 1
    //after = 2, 1.next = 0, before = 1, curr = 2
    //after = 3, 2.next = 1, before = 2, curr = 3
    //after = null, 3.next = 2, before = 3, curr = null
}
