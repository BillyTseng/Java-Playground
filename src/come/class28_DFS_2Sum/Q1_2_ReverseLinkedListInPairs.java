package come.class28_DFS_2Sum;

public class Q1_2_ReverseLinkedListInPairs {
    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode nextNode = reverseInPairs(newHead.next);
        newHead.next = head;
        head.next = nextNode;
        return newHead;
    }
}
