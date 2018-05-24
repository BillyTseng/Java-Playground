package come.class03.attempt02;

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode small = smallDummy;
        ListNode large = largeDummy;
        while (head != null) {
            if (head.value < target) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        small.next = largeDummy.next;
        large.next = null;
        return smallDummy.next;
    }
}
