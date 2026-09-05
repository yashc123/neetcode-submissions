/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Map<Node, Node> daMap = new HashMap<>();
        Node curr = head;

        while(curr != null){
            daMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            if(curr.next != null){
                daMap.get(curr).next = daMap.get(curr.next);
            }
            if(curr.random != null){
                daMap.get(curr).random = daMap.get(curr.random);
            }
            curr = curr.next;
        }

        return daMap.get(head);   


    }
    }

