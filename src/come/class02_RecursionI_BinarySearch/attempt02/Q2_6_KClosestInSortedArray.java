package come.class02_RecursionI_BinarySearch.attempt02;

public class Q2_6_KClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        int[] res = new int[k];
        if (array == null || array.length == 0) {
            return res;
        }

        int left = binarySearch(array, target);
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

    private int binarySearch(int[] array, int target) {
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
}
