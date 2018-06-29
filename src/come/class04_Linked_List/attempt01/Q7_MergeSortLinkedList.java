package come.class04_Linked_List.attempt01;

public class Q7_MergeSortLinkedList {
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode newHead = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(newHead);
        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.value <= right.value) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }
        return dummy.next;
    }
}
