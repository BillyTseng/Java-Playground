package come.class04_Linked_List.attempt01;

public class Q6_PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode currSmall = small;
        ListNode currBig = big;
        while (head != null) {
            if (head.value < target) {
                currSmall.next = head;
                currSmall = currSmall.next;
            } else {
                currBig.next = head;
                currBig = currBig.next;
            }
            head = head.next;
        }
        currSmall.next = big.next;
        currBig.next = null;
        return small.next;
    }
}
