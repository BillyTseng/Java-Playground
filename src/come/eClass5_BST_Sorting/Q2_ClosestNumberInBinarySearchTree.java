package come.eClass5_BST_Sorting;

public class Q2_ClosestNumberInBinarySearchTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    // recursion
    public int closest(TreeNode root, int target) {
        TreeNode next = (target < root.key) ? root.left : root.right;
        if (next == null) {
            return root.key;
        }

        int closestVal = closest(next, target);

        return (Math.abs(closestVal - target) < Math.abs(root.key - target)) ? closestVal : root.key;
    }

    public int closestI(TreeNode root, int target) {
        int res = Integer.MAX_VALUE;
        while (root != null) {
            res = (Math.abs(root.key - target) < Math.abs(res - target)) ? root.key : res;
            root = (target < root.key) ? root.left : root.right;
        }
        return res;
    }
}
