package leet.Q01to50;

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

    /**
     * Example:
     * dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null, k = 3
     * start                  end
     * target list 1->2->3
     * result list 3->2->1
     * return lastNode = 1
     *
     * @param start the start node which is exclude to the target list
     * @param end the end node which is exclude to the target list
     * @return the last node of new list
     */

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode head = start.next;
        // save the last node, which is the original head
        ListNode lastNode = head;
        // de-link start
        start.next = null;
        ListNode prev = end;
        while (head != end) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        // link start with new head
        start.next = prev;
        return lastNode;
    }
}
