package come.class26_BST_DP;

import java.util.HashMap;
import java.util.Map;

public class Q1_1_DeepCopyLinkedListWithRandomPointer {
    class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;

        RandomListNode(int value) {
            this.value = value;
        }
    }

    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> lookup = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.value);
        RandomListNode curr = newHead;
        lookup.put(head, newHead);

        while (head != null) {
            if (head.next != null) {
                if (!lookup.containsKey(head.next)) {
                    lookup.put(head.next, new RandomListNode(head.next.value));
                }
                curr.next = lookup.get(head.next);
            }

            if (head.random != null) {
                if (!lookup.containsKey(head.random)) {
                    lookup.put(head.random, new RandomListNode(head.random.value));
                }
                curr.random = lookup.get(head.random);
            }
            head = head.next;
            curr = curr.next;
        }
        return newHead;
    }
}
