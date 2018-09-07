package come.eClass4_tree.attempt02;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_CheckIfBinaryTreeIsCompleted {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left == null) {
                flag = true;
            } else {
                if (flag) {
                    return false;
                } else {
                    queue.offer(curr.left);
                }
            }

            if (curr.right == null) {
                flag = true;
            } else {
                if (flag) {
                    return false;
                } else {
                    queue.offer(curr.right);
                }
            }
        }
        return true;
    }
}
