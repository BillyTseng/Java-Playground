package come.class10.attempt01;

public class StoreNumberOfNodeInLeftSubTree {
    class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        int leftTotal;

        TreeNode(int key) {
            this.key = key;
        }
    }

    private int getTotal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getTotal(root.left);
        int right = getTotal(root.right);
        root.leftTotal = left;
        return 1 + left + right;
    }
}
