package leet.Q01to50;

public class Q24_SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode newHead = curr.next.next;
            curr.next.next = curr.next.next.next;
            newHead.next = curr.next;
            curr.next = newHead;
            curr = curr.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairsI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }
}
