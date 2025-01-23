/*linked list node
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        if (head == null) 
            return null;
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copyH = head.next;
        while (curr!=null) {
            Node copy = curr.next;
            curr.next = copy.next;
            if(copy.next!=null){
               copy.next = copy.next.next;
            }
            curr= curr.next;
        }
        return copyH;
    }
}
