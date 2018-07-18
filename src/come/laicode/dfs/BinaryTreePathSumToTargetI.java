package come.laicode.dfs;

public class BinaryTreePathSumToTargetI {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    private boolean isExist = false;
    public boolean exist(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        exist(root, target, 0);
        return isExist;
    }

    private void exist(TreeNode root, int target, int sum) {
        if (root == null) {
            if (sum == target) {
                isExist = true;
            }
            return;
        }
        sum += root.key;
        exist(root.left, target, sum);
        exist(root.right, target, sum);
    }
}
