package come.class04_Linked_List.attempt01;

public class Q4_MergeTwoSortedLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (one != null && two != null) {
            if (one.value < two.value) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }
        if (one != null) {
            curr.next = one;
        }
        if (two != null) {
            curr.next = two;
        }
        return dummy.next;
    }
}
