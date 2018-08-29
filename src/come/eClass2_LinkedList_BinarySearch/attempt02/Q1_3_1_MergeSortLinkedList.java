package come.eClass2_LinkedList_BinarySearch.attempt02;

public class Q1_3_1_MergeSortLinkedList {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode merge(ListNode one, ListNode two) {
        if (one == null && two == null) {
            return null;
        }

        if (one == null || two == null) {
            return one == null ? two : one;
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

        if (one != null) {
            cur.next = one;
        }
        if (two != null) {
            cur.next = two;
        }
        return dummy.next;
    }
}
