package come.eClass2_LinkedList_BinarySearch.attempt02;

/**
 * 154. Find Minimum in Rotated Sorted Array II - hard
 */

public class Q2_3_2_FindMinimumInRotatedSortedArrayII {
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
            } else if (input[mid] > input[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }

        return input[left] < input[right] ? input[left] : input[right];
    }
}
