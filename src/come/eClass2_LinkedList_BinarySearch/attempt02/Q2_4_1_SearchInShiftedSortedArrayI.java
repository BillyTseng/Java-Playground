package come.eClass2_LinkedList_BinarySearch.attempt02;

public class Q2_4_1_SearchInShiftedSortedArrayI {
    public int search(int[] input, int target) {
        if (input == null || input.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = input.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (input[mid] == target) {
                return mid;
            }

            if (input[mid] < input[right]) {
                if (input[mid] < target && target <= input[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (input[left] <= target && target < input[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        if (input[right] == target) {
            return right;
        } else if (input[left] == target) {
            return left;
        }
        return -1;
    }
}
