package come.class04.attempt02;

public class TweakedIdenticalBinaryTrees {
    private boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        }
        if (one == null || two == null) {
            return false;
        }

        if (one.key != two.key) {
            return false;
        }
        return isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left) ||
                isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);
    }
}
