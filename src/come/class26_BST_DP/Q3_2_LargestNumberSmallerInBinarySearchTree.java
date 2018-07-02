package come.class26_BST_DP;

public class Q3_2_LargestNumberSmallerInBinarySearchTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int largestSmaller(TreeNode root, int target) {
        int res = Integer.MIN_VALUE;
        while (root != null) {
            if (target <= root.key) {
                root = root.left;
            } else {
                res = root.key;
                root = root.right;
            }
        }
        return res;
    }
}
