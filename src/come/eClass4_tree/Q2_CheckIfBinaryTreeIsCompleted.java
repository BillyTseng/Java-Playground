package come.eClass4_tree;

/* https://app.laicode.io/app/problem/47 */

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
        boolean foundNull = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    if (foundNull) {
                        return false;
                    } else {
                        queue.offer(curr.left);
                    }
                } else {
                    foundNull = true;
                }

                if (curr.right != null) {
                    if (foundNull) {
                        return false;
                    } else {
                        queue.offer(curr.right);
                    }
                } else {
                    foundNull = true;
                }
            }
        }
        return true;
    }
}

