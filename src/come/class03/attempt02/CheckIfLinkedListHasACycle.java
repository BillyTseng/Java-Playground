package come.class03.attempt02;

public class CheckIfLinkedListHasACycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
    }
}
