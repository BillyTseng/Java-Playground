package come.eClass2_LinkedList_BinarySearch;

public class Q2_2_findMaxSmallerThanTarget {
    public int findMaxSmallerThanTarget(int[] input, int target) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int left = 0;
        int right = input.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (input[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public Integer findMaxSmallerThanTargetI(int[] input, int target) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int left = 0;
        int right = input.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (input[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (input[right] < target) {
            return right;
        } else if (input[left] < target) {
            return left;
        }
        return -1;
    }
}
