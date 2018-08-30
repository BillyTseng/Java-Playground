package come.eClass2_LinkedList_BinarySearch.attempt02;

/**
 * 153. Find Minimum in Rotated Sorted Array - medium
 */

public class Q2_3_1_FindMinimumInRotatedSortedArrayI {
    public int findMin(int[] input) {
        if (input == null || input.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = input.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (input[mid] < input[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return input[left] < input[right] ? input[left] : input[right];
    }
}
