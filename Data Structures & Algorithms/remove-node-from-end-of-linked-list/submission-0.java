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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null){
            return null;
        }

        int size = 0;
        ListNode curr = head;

        while(curr != null){
            curr = curr.next;
            size++;
        }

        int nodeRemove = size - n;
        int counter = 0;
        curr = head;

        if(nodeRemove == 0){
            head = head.next;
            return head;
        }

        while(counter < nodeRemove - 1){
            curr = curr.next;
            counter++;
        }

        ListNode temp = curr.next.next;
        curr.next = temp;
        return head;
    }

    /*
    


    */
}
