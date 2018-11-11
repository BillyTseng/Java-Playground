package leet.topics.firms.a;

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

    // time: O(n), space: O(1)
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

    // time: O(n), space: O(1)
    public RandomListNode copyRandomListI(RandomListNode head) {
        if (head == null) {
            return null;
        }

        // 1. establish cloned nodes next to the original nodes.
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode clone = new RandomListNode(curr.label);
            clone.next = curr.next;
            curr.next = clone;
            curr = curr.next.next;
        }

        // 2. assign random pointer for cloned nodes.
        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
            curr = curr.next.next;
        }

        // 3. separate original and cloned list.
        RandomListNode ptrOrgList = head;
        RandomListNode ptrNewList = head.next;
        RandomListNode newHead = head.next;
        while (ptrOrgList != null) {
            ptrOrgList.next = ptrOrgList.next.next;
            ptrNewList.next = (ptrNewList.next == null) ? null : ptrNewList.next.next;
            ptrOrgList = ptrOrgList.next;
            ptrNewList = ptrNewList.next;
        }
        return newHead;
    }
}
