package come.class04;

public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        if (head == null || value <= head.value) {
            ListNode newHead = new ListNode(value);
            newHead.next = head;
            return newHead;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        while (next != null) {
            if (value <= next.value) {
                curr.next = new ListNode(value);
                curr.next.next = next;
                return head;
            }
            next = next.next;
            curr = curr.next;
        }
        curr.next = new ListNode(value);
        return head;
    }
}
