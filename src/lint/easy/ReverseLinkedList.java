package lint.easy;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseLinkedList {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverseRecursion(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
