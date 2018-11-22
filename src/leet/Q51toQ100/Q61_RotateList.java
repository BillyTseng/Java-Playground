package leet.Q51toQ100;

public class Q61_RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // Find the length of the list, n.
        // Move to the tail node.
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        // Link tail and head
        curr.next = head;
        // Move (n - k % n) steps to the front of the new head.
        n = n - k % n;

        // Move n steps
        while (n-- > 0) {
            curr = curr.next;
        }
        // Dis-link tail and new head
        ListNode newHaed = curr.next;
        curr.next = null;
        return newHaed;
    }
}
