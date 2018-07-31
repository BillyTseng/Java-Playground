package come.eClass5_BST_Sorting;

/**
 * convert binary search tree to sorted circular doubly linked list
 */

public class Q5_2_ConvertBSTtoSortedCircularDDL {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int key) {
            val = key;
        }
    }

    private Node prev;
    private Node head;
    public Node treeToDoublyList (Node root) {
        prev = null;
        head = null;

        convert(root);
        return head;
    }

    private void convert(Node root) {
        if (root == null) {
            return;
        }
        convert(root.left);
        Node next = root.right;

        root.left = prev;

        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
        }
        root.right = head;
        head.left = root;

        prev = root;

        convert(next);
    }
}
