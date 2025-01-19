class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if (head == null || head.next == null || k == 0)
            return head;
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        k = k % length;
        if (k == 0)
            return head;
        current = head;
        int count = 1;
        while (count < k) {
            current = current.next;
            count++;
        }
        Node newHead = current.next;
        current.next = null;
        Node tail = newHead;
        while (tail.next != null)
            tail = tail.next;
        tail.next = head; 
        return newHead;
    }
}
