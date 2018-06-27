package come.class24_twoPointer_LCA.attempt01;

import java.util.List;

class TreeNodeK {
    private int key;
    List<TreeNodeK> children;
}

public class Q5_4_LCA_TwoNodesKaryTree {
    private TreeNodeK lowestCommonAncestor(TreeNodeK root, TreeNodeK a, TreeNodeK b) {
        if (root == null || a == root || b == root) {
            return root;
        }

        int cnt = 0;
        TreeNodeK temp = null;
        for (TreeNodeK child : root.children) {
            TreeNodeK node = lowestCommonAncestor(child, a, b);
            if (node != null) {
                cnt++;
                if (cnt == 2) {
                    return root;
                }
                temp = node;
            }
        }
        return temp;
    }

}
