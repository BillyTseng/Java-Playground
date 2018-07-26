package come.class26_BST_DP;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q2_2_MergeKSortedLists {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    class MyComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode p1, ListNode p2) {
            if (p1.value == p2.value) {
                return 0;
            }
            return p1.value < p2.value ? -1 : 1;
        }
    }

    public ListNode merge(List<ListNode> listOfLists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new MyComparator());
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode node : listOfLists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode nodePollFromMinHeap = minHeap.poll();
            if (nodePollFromMinHeap.next != null) {
                minHeap.offer(nodePollFromMinHeap.next);
            }
            cur.next = nodePollFromMinHeap;
            cur = cur.next;
        }

        return dummy.next;
    }
}
