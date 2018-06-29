package come.class02_RecursionI_BinarySearch.attempt01;

public class Q2_4_FirstOccurrence {
    public int firstOccur(int[] array, int target) {
    // Write your solution here
        if (array == null || array.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target <= array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Q2_4_FirstOccurrence solution = new Q2_4_FirstOccurrence();
        // A = {1, 2, 3}, T = 2, return 1
        int[] arr = {1, 2, 3};
        System.out.println(solution.firstOccur(arr, 2));
        // A = {1, 2, 3}, T = 4, return -1
        System.out.println(solution.firstOccur(arr, 4));
        // A = {1, 2, 2, 2, 3}, T = 2, return 1
        arr = new int[] {1, 2, 2, 2, 3};
        System.out.println(solution.firstOccur(arr, 2));
    }
}
