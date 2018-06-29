package come.class03_Queue_Stack.attempt02;

public class ReOrderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode two = mid.next;
        mid.next = null;
        return merge(head, reverse(two));
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print("" + head.value + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReOrderLinkedList solution = new ReOrderLinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        printLinkedList(n1);
        printLinkedList(solution.reorder(n1));
    }
}
