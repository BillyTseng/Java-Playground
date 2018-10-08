package leet.a.attempt02;

import java.util.HashMap;
import java.util.Map;

public class Q146_LRUCache {
    class LRUCache {
        private class Node {
            int key;
            int value;
            Node prev;
            Node next;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private final int capacity;
        private Node head;
        private Node tail;
        private Map<Integer, Node> map;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            remove(node);
            appendToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.value = value;
                remove(node);
            } else if (map.size() < capacity) {
                node = new Node(key, value);
            } else {
                node = tail;
                remove(node);
                node.key = key;
                node.value = value;
            }
            appendToHead(node);
        }

        private void appendToHead(Node node) {
            map.put(node.key, node);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                head.prev = node;
                node.next = head;
                head = node;
            }
        }

        private void remove(Node node) {
            map.remove(node.key);
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node == head) {
                head = node.next;
            }
            if (node == tail) {
                tail = node.prev;
            }
            node.next = null;
            node.prev = null;
        }
    }
}
