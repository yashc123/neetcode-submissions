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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode curr = null;

        if(list1 == null && list2 == null){
            return null;
        }

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        


        while(!(curr1 == null && curr2 == null)){
            if(curr1 != null && curr2 != null){
                if(curr1.val <= curr2.val){
                    if(head == null){
                        head = new ListNode(curr1.val);
                        curr = head;
                    }
                    else{
                        curr.next = new ListNode(curr1.val);
                        curr = curr.next;
                    }
                    curr1 = curr1.next;
                }
                else{
                    if(head == null){
                        head = new ListNode(curr2.val);
                        curr = head;
                    }
                    else{
                        curr.next = new ListNode(curr2.val);
                        curr = curr.next;
                    }
                    curr2 = curr2.next;
                }
            }
            else if(curr1 == null){
                if(head == null){
                    head = new ListNode(curr2.val);
                    curr = head;
                }
                else{
                    curr.next = new ListNode(curr2.val);
                    curr = curr.next;
                }
                curr2 = curr2.next;
            }
            else{
                if(head == null){
                    head = new ListNode(curr1.val);
                    curr = head;
                }
                else{
                    curr.next = new ListNode(curr1.val);
                    curr = curr.next;
                }
                curr1 = curr1.next;
            }
        }

        return head;
    }
}