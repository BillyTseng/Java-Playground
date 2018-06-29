package come.class06_Heap_GraphI_BFS.attempt02;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean notAllowChildFlag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left == null) {
                notAllowChildFlag = true;
            } else if (notAllowChildFlag) {
                return false;
            } else {
                queue.offer(curr.left);
            }
            if (curr.right == null) {
                notAllowChildFlag = true;
            } else if (notAllowChildFlag) {
                return false;
            } else {
                queue.offer(curr.right);
            }
        }
        return true;
    }
}
