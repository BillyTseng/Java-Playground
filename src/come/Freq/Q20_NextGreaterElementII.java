package come.Freq;

/**
 * 503. Next Greater Element II - medium
 */

public class Q20_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];

        for (int i = nums.length * 2 - 2; i >= 0; i--) {
            res[i % nums.length] = -1;
            for (int j = i + 1; j < 2 * nums.length - 1;) {
                if (nums[j % n] > nums[i % n]) {
                    res[i % n] = j % n;
                    break;
                } else if (res[j % n] == -1) {
                    break;
                } else {
                    j = res[j % n];
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (res[i] != -1) {
                res[i] = nums[res[i]];
            }
        }
        return res;
    }
}
