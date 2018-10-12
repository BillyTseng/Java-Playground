package leet.a.freq;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q103_BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(root);
        int lvl = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLvl = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (lvl % 2 == 1) {
                    TreeNode curr = queue.pollLast();
                    currLvl.add(curr.val);
                    if (curr.right != null) {
                        queue.offerFirst(curr.right);
                    }
                    if (curr.left != null) {
                        queue.offerFirst(curr.left);
                    }
                } else {
                    TreeNode curr = queue.pollFirst();
                    currLvl.add(curr.val);
                    if (curr.left != null) {
                        queue.offerLast(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offerLast(curr.right);
                    }
                }
            }
            lvl++;
            res.add(currLvl);
        }
        return res;
    }
}
