package leet.Q01to50;

import java.util.ArrayList;
import java.util.List;

public class Q46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }

    private void permute(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            permute(nums, idx + 1, res);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
