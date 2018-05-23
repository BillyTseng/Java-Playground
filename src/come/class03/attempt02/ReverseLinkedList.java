package come.class03.attempt02;

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class ReverseLinkedList {
    private ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseI(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public ListNode reverseII(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
