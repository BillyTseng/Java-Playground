package come.Freq;

/**
 * 75. Sort Colors - medium
 */

public class Q4_SortColors {
    private final int RED = 0;
    private final int WHITE = 1;
    // private final int BLUE = 2;

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == RED) {
                swap(nums, i++, j++);
            } else if (nums[j] == WHITE) {
                j++;
            } else {    // BLUE
                swap(nums, j, k--);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
