package come.class04_Linked_List.attempt01;

public class Q2_CheckIfLinkedListHasACycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
    }
}
