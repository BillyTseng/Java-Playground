package come.eClass5_BST_Sorting;

/* https://app.laicode.io/app/problem/347 */

public class Q3_2_SecondLargestInBinarySearchTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int secondLargest(TreeNode root) {
        if (root.left == null && root.right == null) {
            return Integer.MIN_VALUE;
        }

        TreeNode prev = null;
        while (root != null && root.right != null) {
            prev = root;
            root = root.right;
        }

        if (root.left != null) {
            return root.left.key;
        } else {
            return prev.key;
        }
    }
}
