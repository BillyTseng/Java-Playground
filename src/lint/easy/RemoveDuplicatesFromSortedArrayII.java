package lint.easy;

public class RemoveDuplicatesFromSortedArrayII {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final int DUP_TIMES = 2;
        int cnt = 1;
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[index] == nums[i]) {
                if (cnt < DUP_TIMES) {
                    nums[++index] = nums[i];
                    cnt++;
                }
            } else {
                cnt = 1;
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
