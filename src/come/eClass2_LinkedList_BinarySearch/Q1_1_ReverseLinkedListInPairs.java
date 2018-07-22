package come.eClass2_LinkedList_BinarySearch;

public class Q1_1_ReverseLinkedListInPairs {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    // recursion
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = reverseInPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }

    // iterative
    public ListNode reverseInPairsI(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode nextNode = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = nextNode;
            prev = cur;
            cur = nextNode;
        }
        return dummy.next;
    }
}
