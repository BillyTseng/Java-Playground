package come.class03.attempt02;

public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (value <= cur.next.value) {
                ListNode tmp = cur.next;
                cur.next = new ListNode(value);
                cur.next.next = tmp;
                return dummy.next;
            }
            cur = cur.next;
        }
        if (cur.next == null) {
            cur.next = new ListNode(value);
        }
        return dummy.next;
    }
}
