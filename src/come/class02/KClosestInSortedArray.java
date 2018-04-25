package come.class02;

import java.util.Arrays;

public class KClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        int[] res = new int[k];
        if (array == null || array.length <= 0) {
            return res;
        }

        int left = findLeastDistanceIndex(array, target);
        int right = left + 1;
        for (int i = 0; i < k; i++) {
            if (right >= array.length || left >= 0 && target - array[left] <= array[right] - target) {
                res[i] = array[left--];
            } else {
                res[i] = array[right++];
            }
        }
        return res;
    }

    private int findLeastDistanceIndex(int[] array, int target) {
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
        return left;
    }

    public static void main(String[] args) {
        KClosestInSortedArray solution = new KClosestInSortedArray();
        // A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(solution.kClosest(arr, 2, 3)));
        // A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
        arr = new int[] {1, 4, 6, 8};
        System.out.println(Arrays.toString(solution.kClosest(arr, 3, 3)));
    }
}
