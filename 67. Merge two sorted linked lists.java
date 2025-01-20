class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        if (head1 == null) 
            return head2;
        if (head2 == null)
            return head1;
        Node resultHead = null;
        if (head1.data <= head2.data) {
            resultHead = head1;
            head1 = head1.next;
        } else {
            resultHead = head2;
            head2 = head2.next;
        }
        Node current = resultHead;
        while (head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }
        return resultHead;
    }
}
