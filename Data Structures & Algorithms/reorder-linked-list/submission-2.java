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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        ListNode second = temp;
        ListNode before = null;
        ListNode after = null;

        while(second != null){
            after = second.next;
            second.next = before;
            before = second;
            second = after;
        }

        ListNode curr1 = head;
        ListNode curr2 = before;

        while(curr1 != null && curr2 != null){
            ListNode temp1 = curr1.next;
            ListNode temp2 = curr2.next;
            curr1.next = curr2;
            curr2.next = temp1;
            curr1 = temp1;
            curr2 = temp2;
        }
        
    }
}

/*





*/


