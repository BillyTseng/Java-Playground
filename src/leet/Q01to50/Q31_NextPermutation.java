package leet.Q01to50;

public class Q31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int targetIdx = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                targetIdx = i - 1;
                break;
            }
        }
        if (targetIdx != Integer.MAX_VALUE) {
            int nextLargerIdx = nums.length - 1;
            while (nextLargerIdx >= 0 && nums[targetIdx] >= nums[nextLargerIdx]) {
                nextLargerIdx--;
            }
            swap(nums, targetIdx, nextLargerIdx);
            reverse(nums, targetIdx + 1);
        } else {
            reverse(nums, 0);
        }
    }
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
