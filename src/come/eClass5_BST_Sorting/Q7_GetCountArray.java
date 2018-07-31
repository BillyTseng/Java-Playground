package come.eClass5_BST_Sorting;

/**
 * 315. Count of Smaller Numbers After Self - Hard
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 */
public class Q7_GetCountArray {
    public int[] countArray(int[] array) {
        int[] indexArray = new int[array.length];
        int[] countArray = new int[array.length];
        int[] helper = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            indexArray[i] = i;
        }

        mergeSort(array, indexArray, countArray, helper, 0, array.length - 1);
        return countArray;
    }

    private void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(array, indexArray, countArray, helper, left, mid);
        mergeSort(array, indexArray, countArray, helper, mid + 1, right);

        merge(array, indexArray, countArray, helper, left, mid, right);
    }

    private void merge(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = indexArray[i];
        }

        int i = left;
        int j = mid + 1;
        int cur = left;
        while (i <= mid) {
            if (j > right || array[helper[i]] <= array[helper[j]]) {
                // (mid + 1) is the origin, j is the counter.
                countArray[helper[i]] += (j - (mid + 1));
                indexArray[cur++] = helper[i++];
            } else {
                // j is also a counter to record smaller than array[helper[i]]
                indexArray[cur++] = helper[j++];
            }
        }
    }
}
