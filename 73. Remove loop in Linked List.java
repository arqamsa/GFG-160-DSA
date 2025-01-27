class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
        if (head == null || head.next == null) 
            return;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                breakLoop (head, slow);
                return;
            }
        }
    }
    private static void breakLoop (Node head, Node meetingPoint){
        Node ptr1 = head;
        Node ptr2 = meetingPoint;
        if (ptr1 == ptr2){
            while (ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
        } else {
            while (ptr1.next != ptr2.next){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        ptr2.next = null;
    }
}
