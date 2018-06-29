package come.class04_Linked_List.etc;

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class CycleNodeInLinkedList {
    public ListNode cycleNode(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
