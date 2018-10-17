package come.eClass6_DFS_Graph.attempt02;

import java.util.ArrayList;
import java.util.List;

public class Q78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, 0, curr, res);
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (nums.length == idx) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        dfs(nums, idx + 1, curr, res);
        curr.remove(curr.size() - 1);

        dfs(nums, idx + 1, curr, res);
    }
}
