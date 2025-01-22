class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        num1 = reverseList(num1);
        num2 = reverseList(num2);
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        while (num1 != null || num2 != null || carry > 0) {
            int sum = carry;
            if(num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            if(num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        Node result = reverseList(dummy.next);
        return removeLeadingZeros(result);
    }
    static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    static Node removeLeadingZeros (Node head){
        while (head != null && head.data == 0)
            head = head.next;
        return head == null ? new Node(0) : head;
    }
}
