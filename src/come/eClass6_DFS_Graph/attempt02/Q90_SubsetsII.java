package come.eClass6_DFS_Graph.attempt02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);

        dfs(nums, 0, curr, res);
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        dfs(nums, idx + 1, curr, res);
        curr.remove(curr.size() - 1);

        while (idx + 1 < nums.length && nums[idx + 1] == nums[idx]) {
            idx++;
        }

        dfs(nums, idx + 1, curr, res);
    }
}
