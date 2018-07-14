package come.class27_RecursionIII.attempt02;

import java.util.HashMap;
import java.util.Map;

public class Q4_2_ReconstructBinaryTreeWithPostorderAndInorder {
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

        return reconstruct(inOrder, 0, inOrder.length - 1,
                postOrder, 0, postOrder.length - 1, inMap);
    }

    private TreeNode reconstruct(int[] inOrder, int inL, int inR,
                                 int[] postOrder, int postL, int postR, Map<Integer, Integer> inMap) {
        if (inL > inR) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postR]);
        int leftLength = inMap.get(root.key) - inL;

        root.left = reconstruct(inOrder, inL, inL + leftLength - 1,
                                postOrder, postL, postL + leftLength - 1, inMap);
        root.right = reconstruct(inOrder, inL + leftLength + 1, inR,
                                postOrder, postL + leftLength, postR - 1, inMap);
        return root;
    }
}
