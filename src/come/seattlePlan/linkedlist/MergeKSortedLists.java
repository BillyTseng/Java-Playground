package come.seattlePlan.linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode merge(List<ListNode> listOfLists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.value == n2.value) {
                    return 0;
                }
                return n1.value < n2.value ? -1 : 1;
            }
        });
//        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> {
//            if (n1.value == n2.value) {
//                return 0;
//            }
//            return n1.value < n2.value ? -1 : 1;
//        });

        for (ListNode node : listOfLists) {
            minHeap.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            ListNode polledNode = minHeap.poll();
            if (polledNode.next != null) {
                minHeap.offer(polledNode.next);
            }
            curr.next = polledNode;
            curr = curr.next;
        }
        return dummy.next;
    }
}
