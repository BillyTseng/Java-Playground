package come.eClass4_tree.attempt02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q3_InOrderTraversalOfBinaryTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        pushLeft(root, stack);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            res.add(curr.key);
            curr = curr.right;
            pushLeft(curr, stack);
        }
        return res;
    }

    private void pushLeft(TreeNode curr, Deque<TreeNode> stack) {
        while (curr != null) {
            stack.offerFirst(curr);
            curr = curr.left;
        }
    }
}
