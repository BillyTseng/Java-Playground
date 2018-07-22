package come.eClass2_LinkedList_BinarySearch;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */

public class Q1_3_2_IntersectionOfTwoLinkedLists {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        ListNode res = null;
        while (headB != null) {
            if (!set.add(headB)) {
                res = headB;
                break;
            }
            headB = headB.next;
        }
        return res;
    }
}
