package come.class02_RecursionI_BinarySearch;
// Variant 1.6: Array 1 2 7 23 57 ... 100 99 86 44 32 21, find the largest element in the array.
public class Q2_8_FindPeakInMountainArray {
    private int searchLargestIndex(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Q2_8_FindPeakInMountainArray solution = new Q2_8_FindPeakInMountainArray();
        int[] array = new int[]{1, 2, 7, 23, 57, 100, 99, 86, 44, 32, 21};
        System.out.println(array[solution.searchLargestIndex(array)]);
    }
}

