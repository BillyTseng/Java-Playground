package come.class10.attempt01;

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class ReverseLinkedListInPairs {
    public ListNode reverseInPairsI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = head.next;
        head.next = reverseInPairsI(head.next.next);
        newNode.next = head;
        return newNode;
    }

    public ListNode reverseInPairsII(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode newHead = cur.next.next;
            cur.next.next = cur.next.next.next;
            newHead.next = cur.next;
            cur.next = newHead;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
