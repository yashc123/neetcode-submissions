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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remainder = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            int result = l1.val + l2.val + remainder;
            if(result < 10){
                curr.next = new ListNode(result);
                curr = curr.next;
                remainder = 0;
            }
            else{
                curr.next = new ListNode(result % 10);
                curr = curr.next;
                remainder = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

       while(l1 != null){
            int result = l1.val + remainder;
            if(result < 10){
                curr.next = new ListNode(result);
                curr = curr.next;
                remainder = 0;
            }
            else{
                curr.next = new ListNode(result % 10);
                curr = curr.next;
                remainder = 1;
            }
            l1 = l1.next;
       }

        while(l2 != null){
            int result = l2.val + remainder;
            if(result < 10){
                curr.next = new ListNode(result);
                curr = curr.next;
                remainder = 0;
            }
            else{
                curr.next = new ListNode(result % 10);
                curr = curr.next;
                remainder = 1;
            }
            l2 = l2.next;
       }

       if(remainder == 1){
            curr.next = new ListNode(1);
       }

       return dummy.next;

    }


}
