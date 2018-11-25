package leet.Q51toQ100;

public class Q75_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        final int RED = 0, WHITE = 1, BLUE = 2;
        int red = 0, white = 0, blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] == RED) {
                swap(nums, red++, white++);
            } else if (nums[white] == WHITE) {
                white++;
            } else { // nums[white] == BLUE
                swap(nums, blue--, white);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
