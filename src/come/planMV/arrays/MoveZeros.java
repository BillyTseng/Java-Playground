package come.planMV.arrays;

public class MoveZeros {
    public int[] moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                //swap(nums, fast, slow++);
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
        return nums;
    }
}
