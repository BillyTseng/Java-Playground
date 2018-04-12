public class SearchinRotatedSortedArray {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            }

            if (A[left] < A[mid]) {
                if (A[left] <= target && target <= A[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (A[mid] <= target && target <= A[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }

        if (A[left] == target) {
            return left;
        }

        if (A[right] == target) {
            return right;
        }

        return -1;
    }
}
