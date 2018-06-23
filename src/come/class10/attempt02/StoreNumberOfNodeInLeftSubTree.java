package come.class10.attempt02;

public class StoreNumberOfNodeInLeftSubTree {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int key;
        int leftTotal;

        TreeNode(int key) {
            this.key = key;
        }
    }

    private int leftTotal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = leftTotal(root.left);
        int right = leftTotal(root.right);
        root.leftTotal = left;
        return 1 + left + right;
    }
}
