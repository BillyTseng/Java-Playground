package come.class03;

public class MiddleNodeOfLinkedList {
    private ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode middleNodeChoseSecondWhileEven(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        MiddleNodeOfLinkedList solution = new MiddleNodeOfLinkedList();
        // 1->2->3->4, middle = 2
        System.out.println(solution.middleNode(n1).value);
        // 1->2->3->4, middle = 3
        System.out.println(solution.middleNodeChoseSecondWhileEven(n1).value);

    }
}
