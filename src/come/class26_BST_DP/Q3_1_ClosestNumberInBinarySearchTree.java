package come.class26_BST_DP;

public class Q3_1_ClosestNumberInBinarySearchTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }


    public int closest(TreeNode root, int target) {
        int[] min = new int[]{Integer.MAX_VALUE};
        closest(root, target, min);
        return min[0];
    }

    private void closest(TreeNode root, int target, int[] min) {
        if (root == null) {
            return;
        }
        if (root.key == target) {
            min[0] = root.key;
            return;
        }

        if (Math.abs(root.key - target) < Math.abs(min[0] - target)) {
            min[0] = root.key;
        }

        if (root.key < target) {
            closest(root.right, target, min);
        } else {
            closest(root.left, target, min);
        }
    }
}
