package come.class03_Queue_Stack.attempt02;

public class MergeTwoSortedLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        if (one == null && two == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            if (one.value <= two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }

        if (one == null) {
            cur.next = two;
        }

        if (two == null) {
            cur.next = one;
        }
        return dummy.next;
    }
}
