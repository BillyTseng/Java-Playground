package come.class04.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public String[] binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new String[0];
        }
        List<String> res = helper(root);
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private List<String> helper(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<String> left = helper(root.left);
        List<String> right = helper(root.right);
        for (String path : left) {
            paths.add(root.key + "->" + path);
        }
        for (String path : right) {
            paths.add(root.key + "->" + path);
        }
        if (paths.size() == 0) {
            paths.add(root.key + "");
        }
        return paths;
    }

}
