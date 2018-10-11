package leet.a.freq;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPostorderAndInorder {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        return buildTree(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, inMap);
    }

    private TreeNode buildTree(int[] inOrder, int inL, int inR, int[] postOrder, int postL, int postR, Map<Integer, Integer> inMap) {
        if (inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postR]);
        int leftLen = inMap.get(root.key) - inL;

        root.left = buildTree(inOrder, inL, inL + leftLen - 1, postOrder, postL, postL + leftLen - 1, inMap);
        root.right = buildTree(inOrder, inL + leftLen + 1, inR, postOrder, postL + leftLen, postR - 1, inMap);
        return root;
    }
}
