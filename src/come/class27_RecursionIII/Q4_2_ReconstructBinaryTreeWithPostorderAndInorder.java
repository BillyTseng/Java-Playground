package come.class27_RecursionIII;

import java.util.HashMap;
import java.util.Map;

/* https://code.laioffer.com/ui/#/app/problem/214 */

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
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            idxMap.put(inOrder[i], i);
        }
        int inR = inOrder.length - 1;
        int postR = postOrder.length - 1;
        return reconstruct(inOrder, 0, inR, postOrder, 0, postR, idxMap);
    }

    private TreeNode reconstruct(int[] inOrder, int inL, int inR,
                                 int[] postOrder, int postL, int postR, Map<Integer, Integer> idxMap) {
        if (inL > inR) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postR]);
        int leftSize = idxMap.get(root.key) - inL;

        root.left = reconstruct(inOrder, inL, inL + leftSize - 1,
                postOrder, postL, postL + leftSize - 1, idxMap);

        root.right = reconstruct(inOrder, inL + leftSize + 1, inR,
                postOrder, postL + leftSize, postR - 1, idxMap);

        return root;
    }
}
