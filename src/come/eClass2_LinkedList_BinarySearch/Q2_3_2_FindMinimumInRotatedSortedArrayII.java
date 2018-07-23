package come.eClass2_LinkedList_BinarySearch;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 */

public class Q2_3_2_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[right];
    }
}
