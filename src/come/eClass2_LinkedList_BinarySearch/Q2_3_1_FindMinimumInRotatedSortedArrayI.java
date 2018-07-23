package come.eClass2_LinkedList_BinarySearch;

/**
 * https://app.laicode.io/app/problem/23
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class Q2_3_1_FindMinimumInRotatedSortedArrayI {
    public int shiftPosition(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
