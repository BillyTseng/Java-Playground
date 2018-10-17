package come.eClass6_DFS_Graph.attempt02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        permuteUnique(nums, 0, res);
        return res;
    }

    private void permuteUnique(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for (int num : nums) {
                curr.add(num);
            }
            res.add(curr);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, idx, i);
                permuteUnique(nums, idx + 1, res);
                swap(nums, idx, i);
            }
        }
    }

    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
