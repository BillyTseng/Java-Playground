package come.class27_RecursionIII;

/* https://code.laioffer.com/ui/#/app/problem/300 */

public class Q3_1_ConvertBinaryTreeToDoublyLinkedListI {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode toDoubleLinkedList(TreeNode root) {
        TreeNode[] head = new TreeNode[] {null};
        TreeNode[] prev = new TreeNode[] {null};
        helper(root, head, prev);
        return head[0];
    }

    private void helper(TreeNode root, TreeNode[] head, TreeNode[] prev) {
        if (root == null) {
            return;
        }

        helper(root.left, head, prev);
        if (prev[0] == null) {
            head[0] = root;
        } else {
            prev[0].right = root;
            root.left = prev[0];
        }
        prev[0] = root;
        helper(root.right, head, prev);
    }
}
