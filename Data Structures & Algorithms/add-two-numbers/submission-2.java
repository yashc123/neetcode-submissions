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

        while(l1 != null || l2 != null || remainder != 0){
            int val1 = 0;
            int val2 = 0;

            if(l1 != null){
                val1 = l1.val;
            }
            if(l2 != null){
                val2 = l2.val;
            }

            int result = val1 + val2 + remainder;
            remainder = result / 10;
            curr.next = new ListNode(result % 10);
            curr = curr.next;

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
        }

        return dummy.next;

    }


}
