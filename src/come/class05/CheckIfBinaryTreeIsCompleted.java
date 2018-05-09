package come.class05;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(curr.left);
            }
            if (curr.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(curr.right);
            }
        }
        return true;
    }
}
