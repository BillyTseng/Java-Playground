package leet.Q51toQ100;

public class Q92_ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode nodeBeforeM = head;
        ListNode nodeM = head.next;
        ListNode nodeN = nodeM;
        ListNode nodeAfterN = nodeM.next;

        for (int i = m; i < n; i++) {
            // nodeAfterN is head, nodeN is prev
            ListNode next = nodeAfterN.next;
            nodeAfterN.next = nodeN;
            nodeN = nodeAfterN;
            nodeAfterN = next;
        }
        nodeM.next = nodeAfterN;
        nodeBeforeM.next = nodeN;
        return dummy.next;
    }
}
