package leet.Q101_150;

import java.util.HashMap;
import java.util.Map;

public class Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        int inR = inorder.length - 1;
        int preR = preorder.length - 1;

        return construct(inorderMap, 0, inR, preorder, 0, preR);
    }

    private TreeNode construct(Map<Integer, Integer> inorderMap, int inL, int inR,
                               int[] preorder, int preL, int preR) {
        if (inL > inR) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preL]);
        int leftLength = inorderMap.get(root.val) - inL;

        root.left = construct(inorderMap, inL, inL + leftLength - 1, preorder, preL + 1, preL + leftLength);
        root.right = construct(inorderMap, inL + leftLength + 1, inR, preorder, preL + leftLength + 1, preR);
        return root;
    }
}
