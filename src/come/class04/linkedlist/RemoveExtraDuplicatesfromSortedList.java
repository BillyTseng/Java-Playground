package come.class04.linkedlist;

public class RemoveExtraDuplicatesfromSortedList {
    public ListNode removeDup(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy.next;

        while (curr != null && curr.next != null) {
            if (curr.value == curr.next.value) {
                int comparedVal = curr.value;
                prev.next = findNextNonDupNode(curr, comparedVal);
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    private ListNode findNextNonDupNode(ListNode curr, int comparedVal) {
        while (curr != null && curr.value == comparedVal) {
            curr = curr.next;
        }
        return curr;
    }
}
