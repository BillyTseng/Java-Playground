package come.planMV.linkedlist;

public class CycleNodeInLinkedList {
    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode cycleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
