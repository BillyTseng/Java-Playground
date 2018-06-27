package come.class24_twoPointer_LCA.attempt01;

class TreeNodeP {
    public int key;
    public TreeNodeP left;
    public TreeNodeP right;
    public TreeNodeP parent;

    public TreeNodeP(int key, TreeNodeP parent) {
        this.key = key;
        this.parent = parent;
    }
}

public class Q5_2_LowestCommonAncestorII {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        int oneLen = getLength(one);
        int twoLen = getLength(two);

        if (oneLen <= twoLen) {
            return findLCA(one, two, twoLen - oneLen);
        } else {
            return findLCA(two, one, oneLen - twoLen);
        }
    }

    private TreeNodeP findLCA(TreeNodeP shorter, TreeNodeP longer, int diff) {
        while (diff > 0) {
            longer = longer.parent;
            diff--;
        }

        while (longer != shorter) {
            longer = longer.parent;
            shorter = shorter.parent;
        }
        return longer;
    }

    private int getLength(TreeNodeP node) {
        int cnt = 0;
        while (node != null) {
            node = node.parent;
            cnt++;
        }
        return cnt;
    }
}
