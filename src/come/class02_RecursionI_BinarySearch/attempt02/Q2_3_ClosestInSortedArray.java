package come.class02_RecursionI_BinarySearch.attempt02;

public class Q2_3_ClosestInSortedArray {
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target <= array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int leftDiff = target - array[left];
        int rightDiff = array[right] - target;
        return (leftDiff <= rightDiff) ? left : right;
    }
}
