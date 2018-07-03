package come.class27_RecursionIII;

/* path from leaf to root */

public class Q2_1_MaxPathSumBinaryTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxPathSum(root, 0);
    }

    private int maxPathSum(TreeNode root, int sum) {
        sum += root.key;
        if (root.left == null && root.right == null) {
            return sum;
        } else if (root.left == null) {
            return maxPathSum(root.right, sum);
        } else if (root.right == null) {
            return maxPathSum(root.left, sum);
        }
        return Math.max(maxPathSum(root.left, sum), maxPathSum(root.right, sum));
    }
}
