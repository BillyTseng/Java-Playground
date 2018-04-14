package lint.easy;

import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                TreeNode target = queue.poll();
                if (target.left != null) {
                    queue.offer(target.left);
                }
                if (target.right != null) {
                    queue.offer(target.right);
                }
                list.add(target.val);
            }
            res.add(list);
        }
        return res;
    }
}
