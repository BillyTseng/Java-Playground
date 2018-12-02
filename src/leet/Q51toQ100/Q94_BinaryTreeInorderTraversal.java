package leet.Q51toQ100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q94_BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);

        while (!stack.isEmpty()) {
            TreeNode polledNode = stack.pollFirst();
            res.add(polledNode.val);
            pushLeft(polledNode.right, stack);
        }
        return res;
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.offerFirst(node);
            node = node.left;
        }
    }
}
