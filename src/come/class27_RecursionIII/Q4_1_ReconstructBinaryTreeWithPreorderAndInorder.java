package come.class27_RecursionIII;

import java.util.HashMap;
import java.util.Map;

public class Q4_1_ReconstructBinaryTreeWithPreorderAndInorder {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            idxMap.put(inOrder[i], i);
        }
        int inR = inOrder.length - 1;
        int preR = preOrder.length - 1;
        return reconstruct(inOrder, 0, inR, preOrder, 0, preR, idxMap);
    }

    private TreeNode reconstruct(int[] inOrder, int inL, int inR,
                                 int[] preOrder, int preL, int preR, Map<Integer, Integer> idxMap) {
        if (inL > inR) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preL]);
        int leftSize = idxMap.get(root.key) - inL;

        root.left = reconstruct(inOrder, inL, inL + leftSize - 1,
                                preOrder, preL + 1, preL + leftSize, idxMap);

        root.right = reconstruct(inOrder, inL + leftSize + 1, inR,
                                 preOrder, preL + leftSize + 1, preR, idxMap);

        return root;
    }
}
