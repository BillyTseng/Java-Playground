package come.class04_Linked_List.etc;

public class RemoveDuplicatesfromSortedList {
    public ListNode removeDup(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.value == curr.next.value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
