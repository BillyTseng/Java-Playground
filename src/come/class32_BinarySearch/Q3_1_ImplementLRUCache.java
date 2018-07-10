package come.class32_BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class Q3_1_ImplementLRUCache<K, V> {
    static class Node<K, V> {
        Node<K, V> next;
        Node<K, V> prev;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        void update(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int limit;
    private Node<K, V> head;
    private Node<K, V> tail;
    private Map<K, Node<K, V>> map;
    // limit is the max capacity of the cache
    public Q3_1_ImplementLRUCache(int limit) {
        this.limit = limit;
        this.map = new HashMap<>();
    }

    public void set(K key, V value) {
        Node<K, V> node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else if (map.size() < limit) {
            node = new Node<>(key, value);
        } else {
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append(node);
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        append(node);
        return node.value;
    }

    private void remove(Node<K, V> node) {
        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        node.next = node.prev = null;
    }

    private void append(Node<K, V> node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
}
