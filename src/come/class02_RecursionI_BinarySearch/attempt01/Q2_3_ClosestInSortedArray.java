package come.class02_RecursionI_BinarySearch.attempt01;

public class Q2_3_ClosestInSortedArray {
    public int closest(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int leftDistance = Math.abs(array[left] - target);
        int rightDistance = Math.abs(array[right] - target);
        return (leftDistance <= rightDistance) ? left : right;
    }

    public static void main(String[] args) {
        Q2_3_ClosestInSortedArray solution = new Q2_3_ClosestInSortedArray();
        // A = {1, 4, 6}, T = 5, return 1 or 2
        int[] arr = new int[] {1, 4, 6};
        System.out.println(solution.closest(arr, 5));
        // A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
        arr = new int[] {1, 3, 3, 4};
        System.out.println(solution.closest(arr, 2));
        // A = {3,4,5,6,6,12,16}, T = 10
        arr = new int[] {3,4,5,6,6,12,16};
        System.out.println(solution.closest(arr, 10));
    }
}
