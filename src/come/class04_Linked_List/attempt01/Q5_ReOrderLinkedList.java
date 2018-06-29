package come.class04_Linked_List.attempt01;

public class Q5_ReOrderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode one = head;
        ListNode two = middle.next;
        // Spilt list one and two.
        middle.next = null;

        return merge(one, reverse(two));
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (one != null && two != null) {
            curr.next = one;
            one = one.next;
            curr.next.next = two;
            two = two.next;
            curr = curr.next.next;
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
