package come.class27_RecursionIII.attempt03;

public class Q1_4_MaximumPathSumBinaryTreeII {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max[0] = Math.max(max[0], root.key + left + right);


        return (left > right) ? root.key + left : root.key + right;
    }
}
