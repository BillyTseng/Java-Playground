package leet.a;

public class Q238_ProductOfArrayExceptSelf {
    /*
        nums               1   2   3 4
        res(right to left) 24  12  4 1
        res(left to right) 24  12  8 6
        left               1   2   6 n/a
    */
    // time O(n), space O(1). The output array does not count as extra space.
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[res.length - 1] = 1;
        for (int i = res.length - 2; i >= 0; i--) {
            res[i] = res[i + 1] * nums[i + 1];
        }
        int left = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] * left;
            left = nums[i] * left;
        }
        return res;
    }
}
