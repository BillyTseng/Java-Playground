package come.class04_Linked_List.etc;

public class DeleteNodeAtIndex {
    public ListNode deleteNode(ListNode head, int index) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int cnt = 0;
        while (head != null && cnt != index) {
            prev = head;
            head = head.next;
            cnt++;
        }
        if (head != null) {
            prev.next = head.next;
        }
        return dummy.next;
    }
}
