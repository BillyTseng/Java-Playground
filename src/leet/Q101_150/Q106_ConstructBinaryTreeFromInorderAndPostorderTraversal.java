package leet.Q101_150;

import java.util.HashMap;
import java.util.Map;

public class Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
public class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            return construct(inorderMap, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode construct(Map<Integer, Integer> inorderMap, int inL, int inR,
                                   int[] postorder, int postL, int postR) {
            if (inL > inR) {
                return null;
            }

            TreeNode root = new TreeNode(postorder[postR]);
            int leftSize = inorderMap.get(root.val) - inL;

            root.left = construct(inorderMap, inL, inL + leftSize - 1, postorder, postL, postL + leftSize - 1);
            root.right = construct(inorderMap, inL + leftSize + 1, inR, postorder, postL + leftSize, postR - 1);
            return root;
        }
}
