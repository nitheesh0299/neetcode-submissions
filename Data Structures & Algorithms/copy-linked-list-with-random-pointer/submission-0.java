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
        Node temp = head;

        Map<Node,Node> headMap = new HashMap<>();
        while(temp!=null){
            headMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        Node copy = new Node(0);
        Node copyhead = copy;
        
        while(temp!=null){
            copyhead.next = headMap.get(temp);
            copyhead = copyhead.next;
            copyhead.next = headMap.get(temp.next);
            copyhead.random = headMap.get(temp.random);
            temp = temp.next;
        }

        return copy.next;
    }
}
