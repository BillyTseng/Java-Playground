package come.eClass2_LinkedList_BinarySearch.attempt02;

public class Q1_1_ReverseLinkedListInPairs {
    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    // Recursion: time O(n), space O(1)
    public ListNode reverseInPairs(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }

        ListNode reversedListHead = reverseInPairs(root.next.next);
        ListNode newHead = root.next;
        newHead.next = root;
        root.next = reversedListHead;
        return newHead;
    }

    // Iterative: time O(n), space O(1)
    public ListNode reverseInPairsI(ListNode root) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = root;
        ListNode cur = root;
        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
