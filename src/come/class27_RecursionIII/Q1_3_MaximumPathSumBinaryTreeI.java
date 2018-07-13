package come.class27_RecursionIII;

public class Q1_3_MaximumPathSumBinaryTreeI {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);

        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], root.key + left + right);
            return Math.max(left, right) + root.key;
        }

        return root.left == null ? right + root.key : left + root.key;
    }
}
