package come.class10.attempt02;


class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class ReverseLinkedListInPairs {
    private ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = reverseInPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode reverseInPairsI(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        dummy.next = head;
        while (curr.next != null && curr.next.next != null) {
            ListNode newHead = curr.next.next;
            curr.next.next = curr.next.next.next;
            newHead.next = curr.next;
            curr.next = newHead;
            curr = curr.next.next;
        }
        return dummy.next;
    }

}

