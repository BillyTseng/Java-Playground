package come.class24_twoPointer_LCA.attempt01;

import java.util.Set;

public class Q5_5_LCA_KNodesKaryTree {
    private TreeNodeK lowestCommonAncestor(TreeNodeK root, Set<TreeNodeK> nodes) {
        if (root == null || nodes.contains(root)) {
            return root;
        }

        int cnt = 0;
        TreeNodeK temp = null;
        for (TreeNodeK child : root.children) {
            TreeNodeK node = lowestCommonAncestor(child, nodes);
            if (node != null) {
                cnt++;
                if (cnt > 1) {
                    return root;
                }
                temp = node;
            }
        }
        return temp;
    }
}
