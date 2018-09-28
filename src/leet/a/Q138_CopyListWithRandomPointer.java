package leet.a;

import java.util.HashMap;
import java.util.Map;

public class Q138_CopyListWithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode orgHead = head;

        while (head != null) {
            RandomListNode copy = map.get(head);
            if (copy == null) {
                copy = new RandomListNode(head.label);
                map.put(head, copy);
            }
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.label));
                }
                copy.random = map.get(head.random);
            }

            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new RandomListNode(head.next.label));
                }
                copy.next = map.get(head.next);
            }
            head = head.next;
        }
        return map.get(orgHead);
    }
}
