package leet;

public class Q25_ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            if (i % k == 0) {
                prev = reverse(prev, curr.next);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode last = start.next;
        ListNode curr = last.next;

        while (curr != end) {
            last.next = curr.next;
            curr.next = start.next;
            start.next = curr;
            curr = last.next;
        }

        return last;
    }
}
