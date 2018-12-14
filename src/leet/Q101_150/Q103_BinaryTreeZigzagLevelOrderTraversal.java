package leet.Q101_150;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);

        int lvl = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currLvl = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (lvl % 2 == 0) {
                    TreeNode node = deque.pollFirst();
                    currLvl.add(node.val);
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                } else {
                    TreeNode node = deque.pollLast();
                    currLvl.add(node.val);

                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
            }
            lvl++;
            res.add(currLvl);
        }
        return res;
    }
}
